package com.example.destroy.textualapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import android.support.v7.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
  private TextInputLayout regname;
  private TextInputLayout regemail;
  private Button regcreatebtn;
  private TextInputLayout regpass;

  ////progress
    private ProgressDialog regprogressDialog;

 ///// toolbar iniatialization
  private Toolbar rtoolbar;
    //////////firebase
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regprogressDialog=new ProgressDialog(this);

        //////finstance
        mAuth = FirebaseAuth.getInstance();

        /////////instance
        regname=(TextInputLayout)findViewById(R.id.reg_display_name);
        regemail=(TextInputLayout)findViewById(R.id.reg_email);
        regpass=(TextInputLayout)findViewById(R.id.reg_pass);
        regcreatebtn=(Button)findViewById(R.id.reg_create_btn);


        rtoolbar=(Toolbar)findViewById(R.id.reg_toolbar);
        setSupportActionBar(rtoolbar);
        getSupportActionBar().setTitle("create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        regcreatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rname=regname.getEditText().getText().toString();
                String email=regemail.getEditText().getText().toString();
                String password=regpass.getEditText().getText().toString();


                if (!TextUtils.isEmpty(rname)||!TextUtils.isEmpty(email)||!TextUtils.isEmpty(password))
                {
                    regprogressDialog.setTitle("Registring user");
                    regprogressDialog.setMessage("please wait while your account is creating");
                    regprogressDialog.setCanceledOnTouchOutside(false);
                    regprogressDialog.show();
                    regmethod(rname,email,password);
                }

            }
        });
    }



    private void regmethod(final String rname, String  email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener( this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser current_user=FirebaseAuth.getInstance().getCurrentUser();
                            String uid=current_user.getUid();
                            mDatabase= FirebaseDatabase.getInstance().getReference().child("Users").child("uid");

                            String device_token= FirebaseInstanceId.getInstance().getToken();
                            // complex data storing
                            HashMap<String, String>usermap=new HashMap<>();
                            usermap.put("name",rname);
                            usermap.put("status","i am a user of textual app by sumon ");
                            usermap.put("image","default");
                            usermap.put("thumb_image","default");
                            usermap.put("device_token",device_token);


                            mDatabase.setValue(usermap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){

                                   regprogressDialog.dismiss();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent mainint=new Intent(RegisterActivity.this,MainActivity.class);
                                 mainint.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                 startActivity(mainint);

                                    }
                                }
                            });




                        } else {
                            // If sign in fails, display a message to the user.

                            regprogressDialog.hide();
                            Toast.makeText(RegisterActivity.this, "sorry you can not register please check again.", Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
}
