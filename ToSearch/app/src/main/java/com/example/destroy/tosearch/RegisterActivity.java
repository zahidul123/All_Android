package com.example.destroy.tosearch;

import android.app.ProgressDialog;
import android.content.Intent;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private EditText regemail,regpass,regconfirmpass;
    private Button registerbtn;

    private ProgressDialog loadingBar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth=FirebaseAuth.getInstance();

        regemail=(EditText)findViewById(R.id.email);
        regpass=(EditText)findViewById(R.id.password);
        regconfirmpass=(EditText)findViewById(R.id.confirm_password);

        registerbtn=(Button)findViewById(R.id.registeration);

        //progress dialogue

        loadingBar=new ProgressDialog(this);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateNewAccount();
            }
        });

    }

    private void CreateNewAccount() {
        String email=regemail.getText().toString().trim();
        String password=regpass.getText().toString().trim();
        String confirmpass=regconfirmpass.getText().toString().trim();
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(confirmpass)){
            Toast.makeText(this, "please enter confirm password", Toast.LENGTH_SHORT).show();
        }else if (!password.equals(confirmpass)){
            Toast.makeText(this, "please enter enter same password", Toast.LENGTH_SHORT).show();
        }else{

            loadingBar.setTitle("creating account");
            loadingBar.setMessage("please wait untill create your account");
            loadingBar.show();
            loadingBar.setCanceledOnTouchOutside(true);

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                               SetupActivitygone();
                                Toast.makeText(RegisterActivity.this, "you are registered succesfully", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                            } else {
                                String message=task.getException().getMessage();
                                Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }

                        }
                    });
        }
    }

    private void SetupActivitygone() {
        Intent  newactivity=new Intent(RegisterActivity.this,SetupActivity.class);
        newactivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(newactivity);
        finish();
    }


    @Override
    protected void onStart() {

        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser!=null){
            //if user already registered
            sendUserToMainActivity();
        }
    }


    private void sendUserToMainActivity() {

        Intent  newactivity=new Intent(RegisterActivity.this,MainActivity.class);
        newactivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(newactivity);
        finish();
    }
}
