package com.example.habib.infobook;

import android.app.ProgressDialog;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    private EditText nName;
    private EditText nEmail;
    private EditText nPassword;
    private EditText nId;
    private Button nLogIn;
    private Button nRegister;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    DatabaseReference databaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nName=(EditText)findViewById(R.id.name);
        nPassword=(EditText)findViewById(R.id.password);
        nId=(EditText)findViewById(R.id.id);
        nEmail=(EditText)findViewById(R.id.email);



        nRegister=(Button)findViewById(R.id.register);

        mAuth = FirebaseAuth.getInstance();
        databaseUser = FirebaseDatabase.getInstance().getReference("Users");
        final ProgressDialog progress = new ProgressDialog(this);


        nRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                progress.setTitle("Loading");
                progress.setMessage("Wait while loading...");
                progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
                progress.show();
                final String name=nName.getText().toString();
                final String nid=nId.getText().toString();
                final String email=nEmail.getText().toString();
                final String password=nPassword.getText().toString();
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){

                            Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            addUser(name,nid,email,password,progress);

                        }
                    }
                });

            }
        });


       mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in

                } else {
                    // User is signed out

                }

            }
        };


    }

    public void addUser(String name,String nid,String email,String password,ProgressDialog progress){
        FirebaseUser Currentuser=mAuth.getCurrentUser();
        Users user = new Users(name, nid);
        databaseUser.child(Currentuser.getUid().toString()).setValue(user);
        progress.dismiss();
        Toast.makeText(MainActivity.this,"Successs",Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }

    }


}
