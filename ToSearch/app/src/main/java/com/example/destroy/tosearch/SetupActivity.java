package com.example.destroy.tosearch;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class SetupActivity extends AppCompatActivity {

    private EditText username,fullname,country;
    private Button saveinformation;
    private CircleImageView profileimage;

    private FirebaseAuth mAuth;
    private DatabaseReference databaseref;
    String currentuserid;
    private ProgressDialog loadingBar;

    private StorageReference profileimagestorageref;
    public static int galerry_pick=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        mAuth=FirebaseAuth.getInstance();
        FirebaseUser checkvalidity=mAuth.getCurrentUser();
        if (checkvalidity!=null){
            currentuserid=mAuth.getCurrentUser().getUid();
            databaseref=FirebaseDatabase.getInstance().getReference().child("users").child(currentuserid);
            profileimagestorageref= FirebaseStorage.getInstance().getReference().child("profile images");
        }else{
            Intent intent=new Intent(SetupActivity.this,SetupActivity.class);
            startActivity(intent);
        }




        username=(EditText)findViewById(R.id.status_username);
        fullname=(EditText)findViewById(R.id.status_full_name);
        country=(EditText)findViewById(R.id.status_country);

        saveinformation=(Button)findViewById(R.id.status_save);
        profileimage=(CircleImageView)findViewById(R.id.status_profile);

        loadingBar=new ProgressDialog(this);



        profileimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galeryimage=new Intent();
                galeryimage.setType("image/*");
                galeryimage.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(galeryimage,galerry_pick);

            }
        });



        databaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    if (dataSnapshot.hasChild("profileimage")) {
                        String image = dataSnapshot.child("profileimage").getValue().toString();
                        Picasso.with(SetupActivity.this)
                                .load(image)
                                .placeholder(R.drawable.profile_icon)
                                .into(profileimage);
                    }else {
                        Toast.makeText(SetupActivity.this, "you have no profile pic", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        saveinformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAccountsetupInformation();
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==galerry_pick && resultCode==RESULT_OK && data!=null){

            Uri  imageuri=data.getData();

            CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1,1)
                    .start(this);
        }


            if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);

                if (resultCode == RESULT_OK) {

                    loadingBar.setTitle("saving information");
                    loadingBar.setMessage("please wait untill saving information........");
                    loadingBar.show();
                    loadingBar.setCanceledOnTouchOutside(true);

                    Uri resultUri = result.getUri();

                    StorageReference filepath=profileimagestorageref.child(currentuserid+".jpg");

                    filepath.putFile(resultUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                            if (task.isSuccessful()){

                                Toast.makeText(SetupActivity.this, "image load successfully", Toast.LENGTH_SHORT).show();
                                final String downloadurl=task.getResult().getDownloadUrl().toString();


                               databaseref.child("profileimage").setValue(downloadurl).addOnCompleteListener(new OnCompleteListener<Void>() {
                                   @Override
                                   public void onComplete(@NonNull Task<Void> task) {
                                       
                                       
                                       if (task.isSuccessful()){

                                        //   Intent setupactivity=new Intent(SetupActivity.this,MainActivity.class);
                                         //  startActivity(setupactivity);

                                           saveAccountsetupInformation();
                                           Toast.makeText(SetupActivity.this, "profile image stored the file", Toast.LENGTH_SHORT).show();

                                           loadingBar.dismiss();
                                       }
                                       else{
                                           String message=task.getException().getMessage();
                                           Toast.makeText(SetupActivity.this, "Error "+message, Toast.LENGTH_SHORT).show();

                                           loadingBar.dismiss();
                                       }

                                   }
                               });
                            }
                        }
                    });

                }
                else{

                    Toast.makeText(SetupActivity.this, "some error occoured so image doesnot correped ", Toast.LENGTH_SHORT).show();


                loadingBar.dismiss();
                }
            }

    }

    private void saveAccountsetupInformation()
    {
        String uname=username.getText().toString();
        String fname=fullname.getText().toString();
        String desh=country.getText().toString();

        if (TextUtils.isEmpty(uname)){
            Toast.makeText(this, "please enter right user name", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(fname)){
            Toast.makeText(this, "please enter full name", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(desh)){
            Toast.makeText(this, "please enter country", Toast.LENGTH_SHORT).show();
        }
        else{

            loadingBar.setTitle("saving information");
            loadingBar.setMessage("please wait untill saving information........");
            loadingBar.show();
            loadingBar.setCanceledOnTouchOutside(true);

            HashMap usermap=new HashMap();
            usermap.put("username",uname);
            usermap.put("fullname",fname);
            usermap.put("country",desh);
            usermap.put("status","enginner");
            usermap.put("gender","none");
            usermap.put("dob","none");
            usermap.put("marridstatus","none");

            databaseref.updateChildren(usermap).addOnCompleteListener(new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    if (task.isSuccessful()){
                        sendToMainactivity();
                        Toast.makeText(SetupActivity.this, "successfully update all data", Toast.LENGTH_SHORT).show();

                   loadingBar.dismiss();
                    }else{
                        String message=task.getException().getMessage();
                        Toast.makeText(SetupActivity.this, "Error "+message, Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    }
                }
            });

        }
    }


    private void sendToMainactivity() {
        Intent newactivity=new Intent(SetupActivity.this,MainActivity.class);
        newactivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(newactivity);
        finish();
    }
}
