package com.example.imagestoringfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {
    private EditText name,email,phone,password;
    private Button login,register;
    private ProgressBar progressBar;
    private StorageReference mStorageRef;
    private FirebaseAuth mAuth;
    Admin ad;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   mAuth = FirebaseAuth.getInstance();

        name=findViewById(R.id.ename);
        email=findViewById(R.id.eemail);
        phone=findViewById(R.id.ephone);
        password=findViewById(R.id.epassword);
        progressBar=findViewById(R.id.progressbar);
        login=findViewById(R.id.elogin);
        register=findViewById(R.id.eregistration);
        progressBar.setVisibility(View.INVISIBLE);
        ad=new Admin(name.getText().toString().trim(),email.getText().toString().trim(),password.getText().toString().trim()
        ,phone.getText().toString().trim());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.setVisibility(View.INVISIBLE);
                register.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                String usrnm=name.getText().toString().trim();
               myRef = FirebaseDatabase.getInstance().getReference().child("admin_information");
              ad.getName();
              ad.getEmail();
              ad.getPass();
              ad.getPhone();
               myRef.child(usrnm).setValue(ad).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(),"account created again",Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });



            }
        });
    }
}
