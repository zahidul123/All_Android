package com.example.reglogimginfirebasewithimg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class userregistration extends AppCompatActivity {
    private EditText name,email,phone,password;
    private Button login,register;
    private ImageView imageview;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;
    static int PReqCode = 1 ;
    static int REQUESCODE = 1 ;
    Uri pickedImgUri ;
    private StorageReference mStorageRef;
    user us;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregistration);
        mAuth = FirebaseAuth.getInstance();

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.password);
        imageview=findViewById(R.id.userimage);

        progressBar=findViewById(R.id.progressbar);
        login=findViewById(R.id.login);
        register=findViewById(R.id.registration);
        progressBar.setVisibility(View.INVISIBLE);
       us=new user();
       imageview.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(userregistration.this,"you are clicked",Toast.LENGTH_LONG).show();
               Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
               galleryIntent.setType("image/*");
               startActivityForResult(galleryIntent,REQUESCODE);
           }
       });
       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               login.setVisibility(View.INVISIBLE);
               register.setVisibility(View.INVISIBLE);
               progressBar.setVisibility(View.VISIBLE);
               String usrnm=name.getText().toString().trim();
               String usrmil=email.getText().toString().trim();
               String usrpass=password.getText().toString().trim();
               String usrphn=phone.getText().toString().trim();

               if (usrnm.isEmpty()) {
                   name.setError(getString(R.string.input_error_name));
                   name.requestFocus();
                   return;
               }

                else if (usrmil.isEmpty()) {
                   email.setError(getString(R.string.input_error_email));
                   email.requestFocus();
                   return;
               }


               else if (usrpass.isEmpty()) {
                   password.setError(getString(R.string.input_error_password));
                   password.requestFocus();
                   return;
               }


               else if (usrphn.isEmpty()) {
                   phone.setError(getString(R.string.input_error_phone));
                   phone.requestFocus();
                   return;
               }else{
                   CreateUserAccount(usrnm,usrmil,usrpass,usrphn);
               }


           }
       });
    }

    private void CreateUserAccount(final String usrnm, final String usrmil, final String usrpass, final String usrphn) {

        mAuth.createUserWithEmailAndPassword(usrmil,usrpass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // user account created successfully
                            Toast.makeText(getApplicationContext(),"account is created",Toast.LENGTH_LONG).show();
                            // after we created user account we need to update his profile picture and name
                            updateUserInfo( usrnm ,pickedImgUri,usrmil,usrpass,usrphn);
                            Intent intent=new Intent(userregistration.this,userfield.class);
                            startActivity(intent);

                        }
                        else
                        {

                            // account creation failed
                            Toast.makeText(getApplicationContext(),"account creation failed" + task.getException().getMessage(),Toast.LENGTH_LONG).show();

                            register.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.INVISIBLE);

                        }
                    }
                });
    }



    private void updateUserInfo(final String names, Uri pickedImgUri, final String usrmil,final String usrpass,final String usrphone){

        mStorageRef = FirebaseStorage.getInstance().getReference().child("users_photos");
        final StorageReference imageFilePath = mStorageRef.child("image"+pickedImgUri.getLastPathSegment());

        imageFilePath.putFile(pickedImgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                imageFilePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        // uri contain user image url

                        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("user_information");

                        us.setName(name.getText().toString().trim());
                        us.setEmail(email.getText().toString().trim());
                        us.setPass(password.getText().toString().trim());
                        us.setPhone(phone.getText().toString().trim());
                        us.setImage(String.valueOf(uri));
                        myRef.setValue(us).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(userregistration.this,"here is all",Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });
            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUESCODE && data != null ) {

            // the user has successfully picked an image
            // we need to save its reference to a Uri variable
            pickedImgUri = data.getData() ;
            imageview.setImageURI(pickedImgUri);


        }


    }

}
