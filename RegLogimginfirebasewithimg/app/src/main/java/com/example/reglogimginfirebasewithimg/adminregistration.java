package com.example.reglogimginfirebasewithimg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;

public class adminregistration extends AppCompatActivity {
    private EditText name,email,phone,password;
    private Button login,register;
    private ProgressBar progressBar;
    private StorageReference mStorageRef;
    private FirebaseAuth mAuth;
    admin ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminregistration);
        mAuth = FirebaseAuth.getInstance();

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.password);
        progressBar=findViewById(R.id.progressbar);
        login=findViewById(R.id.login);
        register=findViewById(R.id.registration);
        progressBar.setVisibility(View.INVISIBLE);
        ad=new admin();
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
                            DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("admin_information");
                            ad.setName(name.getText().toString().trim());
                            ad.setEmail(email.getText().toString().trim());
                            ad.setPass(password.getText().toString().trim());
                            ad.setPhone(phone.getText().toString().trim());
                            myRef.child(usrnm).setValue(ad).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getApplicationContext(),"account created again",Toast.LENGTH_LONG).show();
                                    Intent intent=new Intent(adminregistration.this,admindoaction.class);
                                    startActivity(intent);
                                }
                            });

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
}
