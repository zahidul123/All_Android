package com.example.destroy.textualapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.TextView;
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
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;
import id.zelory.compressor.Compressor;

public class SettingActivity extends AppCompatActivity {
    private DatabaseReference setdataref;
    private FirebaseUser settcurrentuser;


    //instance
    private TextView setname;
    private TextView setstatus;


    private CircleImageView setimage;


    private Button setbtnimg;
    private Button setbtnstatus;

    private int gelary_photo=1;
    private ProgressDialog mprocessdialoge;
    //storage referrences
    private StorageReference mimageStorageRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        setimage=(CircleImageView)findViewById(R.id.settcircleImageView);
        setstatus=(TextView)findViewById(R.id.setting_status);
        setname=(TextView)findViewById(R.id.setting_name);
        setbtnimg=(Button)findViewById(R.id.setting_image_btn);
        setbtnstatus=(Button)findViewById(R.id.setting_status_btn);





        settcurrentuser= FirebaseAuth.getInstance().getCurrentUser();

        mimageStorageRef = FirebaseStorage.getInstance().getReference();
        String uid=settcurrentuser.getUid();


        setdataref= FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
        setdataref.keepSynced(true);

        setdataref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name=dataSnapshot.child("name").getValue().toString();
                final String image=dataSnapshot.child("image").getValue().toString();
                String status=dataSnapshot.child("status").getValue().toString();
                String thumb_image=dataSnapshot.child("thumb_image").getValue().toString();

                setname.setText(name);
                setstatus.setText(status);
             if (!image.equals("default")){


                 Picasso.with(SettingActivity.this).load(image).networkPolicy(NetworkPolicy.OFFLINE)
                         .placeholder(R.drawable.frame).into(setimage, new Callback() {
                     @Override
                     public void onSuccess() {

                     }

                     @Override
                     public void onError() {
                         Picasso.with(SettingActivity.this).load(image).placeholder(R.drawable.frame).into(setimage);
                     }
                 });
             }

              // Toast.makeText(SettingActivity.this,dataSnapshot.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        setbtnstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String statu_value=setstatus.getText().toString();
                Intent stts=new Intent(SettingActivity.this,StatusActivity.class);
                stts.putExtra("status_value",statu_value);
                startActivity(stts);
            }
        });




        setbtnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //image selection procees from gelary
                Intent gelaryintent=new Intent();
                gelaryintent.setType("image/*");
                gelaryintent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(gelaryintent,"select image"),gelary_photo);


                /*
                // start picker to get image for cropping and then use the image in cropping activity
                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .start(SettingActivity.this);
                        */
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==gelary_photo && resultCode==RESULT_OK){
            Uri imageUri=data.getData();

            // start cropping activity for pre-acquired image saved on the device
            CropImage.activity(imageUri).setAspectRatio(1,1).start(this);

           // Toast.makeText(SettingActivity.this,imageuri,Toast.LENGTH_SHORT).show();
        }

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {

                mprocessdialoge =new ProgressDialog(SettingActivity.this);
                mprocessdialoge.setTitle("uploading image........");
                mprocessdialoge.setMessage("please wait while your image has been uploading ");
                mprocessdialoge.setCanceledOnTouchOutside(false);
                mprocessdialoge.show();


                Uri resultUri = result.getUri();

                File thumb_filepath=new File(resultUri.getPath());

                String current_user_id=settcurrentuser.getUid();


                Bitmap thumb_bitmap = null;
                try {
                    thumb_bitmap = new Compressor(this)
                            .setMaxHeight(200)
                            .setMaxWidth(200)
                            .setQuality(75)
                            .compressToBitmap(thumb_filepath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    thumb_bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    final byte[] thumb_byte = baos.toByteArray();




                StorageReference filepath=mimageStorageRef.child("Profile_images").child(current_user_id+".jpg");
                final StorageReference thum_filepath=mimageStorageRef.child("Profile_images").child("thumb").child(current_user_id+".jpg");


                filepath.putFile(resultUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                        if (task.isSuccessful()){
                            final String download_url=task.getResult().getDownloadUrl().toString();


                            UploadTask uploadTask = thum_filepath.putBytes(thumb_byte);
                            uploadTask.addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> thumb_task) {

                                    String thumb_download=thumb_task.getResult().getDownloadUrl().toString();
                                    if (thumb_task.isSuccessful()){
                                        Map update_hasmap=new HashMap<>();
                                        update_hasmap.put("image",download_url);
                                        update_hasmap.put("thumb_image",thumb_download);

                                        setdataref.updateChildren(update_hasmap).addOnCompleteListener(new OnCompleteListener<Void>(){
                                            public void onComplete(Task<Void>task){
                                                if(task.isSuccessful()){
                                                    mprocessdialoge.dismiss();
                                                    Toast.makeText(SettingActivity.this,"upload succesfull",Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });

                                    }else{
                                       Toast.makeText(SettingActivity.this,"error in thumbnill",Toast.LENGTH_SHORT).show();
                                        mprocessdialoge.dismiss();
                                    }

                                }
                            });


                        }else{
                            Toast.makeText(SettingActivity.this,"not working",Toast.LENGTH_SHORT).show();
                            mprocessdialoge.dismiss();
                        }
                    }
                });
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }


    public static String random() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(10);
        char tempChar;
        for (int i = 0; i < randomLength; i++){
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }

}
