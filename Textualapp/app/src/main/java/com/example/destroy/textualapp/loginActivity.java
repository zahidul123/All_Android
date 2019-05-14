package com.example.destroy.textualapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

import java.security.PrivateKey;

public class loginActivity extends AppCompatActivity {
    private EditText lemail;
    private EditText lpass;
    private Button lbutton;

    private Toolbar ltoolbar;
    private ProgressDialog progress;

    private FirebaseAuth mAuth;
    private DatabaseReference mlogdaabaseref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        progress=new ProgressDialog(this);


        mAuth = FirebaseAuth.getInstance();

        lemail=(EditText)findViewById(R.id.login_name);
        lpass=(EditText)findViewById(R.id.login_pass);
        lbutton=(Button)findViewById(R.id.login_btn1);

        ltoolbar=(Toolbar)findViewById(R.id.login_appbar);
        setSupportActionBar(ltoolbar);
        getSupportActionBar().setTitle("Log in");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         mlogdaabaseref= FirebaseDatabase.getInstance().getReference().child("Users");

        lbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=lemail.getText().toString();
                String password=lpass.getText().toString();

                if (!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)){
                    progress.setTitle("Login user");
                    progress.setMessage("please wait while your account is creating");
                    progress.setCanceledOnTouchOutside(false);
                    progress.show();
                    login(email,password);
                }
            }
        });

    }

    private void login(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {


                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();

                            progress.dismiss();

                            String user_curent_id=mAuth.getCurrentUser().getUid();
                            String devicetoken= FirebaseInstanceId.getInstance().getToken();

                            mlogdaabaseref.child(user_curent_id).child("token_device").setValue(devicetoken).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Intent intt=new Intent(loginActivity.this,MainActivity.class);
                                    intt.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intt);
                                    finish();

                                }
                            });



                        } else {

                            progress.hide();
                            // If sign in fails, display a message to the user.
                            Toast.makeText(loginActivity.this, "Authentication failed.",Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }
}
