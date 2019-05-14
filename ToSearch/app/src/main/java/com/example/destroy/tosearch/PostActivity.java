package com.example.destroy.tosearch;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class PostActivity extends AppCompatActivity {

    private Toolbar mtoolbar;
    private ImageButton selectImagePost;
    private Button updatepostbutton;
    private EditText postDescription;
    private static final int galerry_pick=1;
    private Uri imageuri;
    private String dscription;
    private FirebaseAuth mAuth;

    private StorageReference postimageStoreRef;
    private String saveCurrentdate,SaveCurrentTime,postRandomName,downloadUrl,current_user_id;
    private DatabaseReference userdatabaseref;
    private DatabaseReference postref;


    private ProgressDialog loadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mAuth=FirebaseAuth.getInstance();

         FirebaseUser  checkvalidity = mAuth.getCurrentUser();

      //  if (checkvalidity!=null) {

            current_user_id = mAuth.getCurrentUser().getUid();
       // }else{
          //  Toast.makeText(this, "you are not authenticate", Toast.LENGTH_SHORT).show();
       // }


        postimageStoreRef= FirebaseStorage.getInstance().getReference();

        userdatabaseref= FirebaseDatabase.getInstance().getReference().child("users");
                 postref= FirebaseDatabase.getInstance().getReference().child("posts");

        mtoolbar=(Toolbar)findViewById(R.id.update_post_page_toolbar);

      loadingBar=new ProgressDialog(this);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("New post");

        selectImagePost=(ImageButton)findViewById(R.id.select_post_image);

        postDescription=(EditText)findViewById(R.id.select_post_descriptin);
        updatepostbutton=(Button)findViewById(R.id.select_post_ok);

        selectImagePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        updatepostbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PostActivity.this, "button is clicked", Toast.LENGTH_SHORT).show();
                ValidatePostInfo();
            }
        });

    }



    private void ValidatePostInfo() {
        Toast.makeText(PostActivity.this, "by clicking button we are new method", Toast.LENGTH_SHORT).show();
         dscription=postDescription.getText().toString();
        if (imageuri.equals(null)){
            Toast.makeText(this, "please Select image ", Toast.LENGTH_SHORT).show();
        }
       else if (TextUtils.isEmpty(dscription)){
            Toast.makeText(this, "please write something in description ", Toast.LENGTH_SHORT).show();
        }else
        {
            loadingBar.setTitle("Add new post");
            loadingBar.setMessage("please wait untill updating new post........");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            storingImageFirebaseDatabase();

        }
    }



    private void storingImageFirebaseDatabase() {

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        saveCurrentdate = df.format(c);

        Calendar calendertime=Calendar.getInstance();
        SimpleDateFormat currenttime=new SimpleDateFormat("HH-mm");
        SaveCurrentTime=currenttime.format(calendertime.getTime());

        StorageReference ref=FirebaseStorage.getInstance().getReference();

        postRandomName=saveCurrentdate+SaveCurrentTime;

        StorageReference filepath=postimageStoreRef.child("post image").child(imageuri.getLastPathSegment()+postRandomName+".jpg");

        Toast.makeText(PostActivity.this, "Iam in saving informationdatabase method"+filepath, Toast.LENGTH_LONG).show();

        filepath.putFile(imageuri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                if (task.isSuccessful()){
                    downloadUrl=task.getResult().getDownloadUrl().toString();
                    Toast.makeText(PostActivity.this, "Image Upload succes fully to  uplopad", Toast.LENGTH_SHORT).show();
                    savingInformationToDatabase();
                }else {
                    String message=task.getException().getMessage();
                    Toast.makeText(PostActivity.this, "error :"+message, Toast.LENGTH_SHORT).show();
                }
            }
        });

/*
        filepath.putFile(imageuri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                         downloadUrl = taskSnapshot.getDownloadUrl().toString();
                        savingInformationToDatabase();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                        Toast.makeText(PostActivity.this, "error happend"+exception, Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                    }
                });
        */
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==galerry_pick && resultCode==RESULT_OK && data!=null&&data.getData()!=null){
            imageuri=data.getData();
            selectImagePost.setImageURI(imageuri); //display pic to image view
        }
    }

    //image save to database
    private void savingInformationToDatabase() {

        userdatabaseref.child(current_user_id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){

                    String userfullname=dataSnapshot.child("fullname").getValue().toString(); // ei khane vul ase
                    String userprofileimage=dataSnapshot.child("profileimage").getValue().toString();

                    HashMap postMap=new HashMap();
                    postMap.put("uid",current_user_id);
                    postMap.put("date",saveCurrentdate);
                    postMap.put("time",SaveCurrentTime);
                    postMap.put("description",postDescription);
                    postMap.put("postimage",downloadUrl);
                    postMap.put("profileimage",userprofileimage);
                    postMap.put("fullname",userfullname);

                    Toast.makeText(PostActivity.this, "Iam in saving informationdatabase method", Toast.LENGTH_LONG).show();


                    postref.child(current_user_id+postRandomName).updateChildren(postMap).addOnCompleteListener(new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (task.isSuccessful()){
                                sendmainActivity();
                                Toast.makeText(PostActivity.this, "new post is update succes fully", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }else{
                                String message=task.getException().getMessage();
                                Toast.makeText(PostActivity.this, "error "+message, Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }
                        }
                    });
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void openGallery() {

        Intent galeryimage=new Intent();
        galeryimage.setAction(Intent.ACTION_GET_CONTENT);
        galeryimage.setType("image/*");
        startActivityForResult(galeryimage,galerry_pick);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==android.R.id.home){
            sendmainActivity();
        }
        return super.onOptionsItemSelected(item);
    }




    private void sendmainActivity() {
        Intent intent=new Intent(PostActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
