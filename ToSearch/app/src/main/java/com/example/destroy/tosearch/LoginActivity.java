package com.example.destroy.tosearch;

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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private EditText lemail;
    private EditText lpassword;
    private TextView needaccount;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;
    private ImageView googlesigninbtn;

    private static final int RC_SIGN_IN=1;
    private GoogleApiClient mGoogleSignInClient;
    private static final String TAG="LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth=FirebaseAuth.getInstance();

        needaccount=(TextView)findViewById(R.id.noaccount);

        lemail=(EditText)findViewById(R.id.log_mail);
        lpassword=(EditText)findViewById(R.id.log_pass);

        login=(Button)findViewById(R.id.login);
        googlesigninbtn=(ImageView)findViewById(R.id.login_google);
        loadingBar=new ProgressDialog(this);

        needaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent regintent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(regintent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userlogin();
            }
            
        });

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient=new GoogleApiClient.Builder(this).enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
            @Override
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                Toast.makeText(LoginActivity.this, "connection to google api is failed", Toast.LENGTH_SHORT).show();
            }
        }).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();

        googlesigninbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }


    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleSignInClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            loadingBar.setTitle("google sign  in");
            loadingBar.setMessage(" log in with google account................");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()){
                GoogleSignInAccount signaccount=result.getSignInAccount();
                firebaseAuthWithGoogle(signaccount);
                Toast.makeText(this, "please wait   we are try to singn in you", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "sorry......sign in failed ", Toast.LENGTH_SHORT).show();
                loadingBar.dismiss();
            }
        }
    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                           // FirebaseUser user = mAuth.getCurrentUser();
                            sendUserToMainActivity();
                            loadingBar.dismiss();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            String message=task.getException().getMessage();
                            sendUsertologinActivity();
                            Toast.makeText(LoginActivity.this, "try again "+message, Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();
                        }

                        // ...
                    }
                });
    }



    private void sendUsertologinActivity() {
        Intent intent=new Intent(LoginActivity.this,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void userlogin() {

        String email=lemail.getText().toString();
        String password=lpassword.getText().toString();

        if (TextUtils.isEmpty(email)){

            Toast.makeText(this, "please enter your email id ", Toast.LENGTH_SHORT).show();

        }
        else  if (TextUtils.isEmpty(password)){

            Toast.makeText(this, "please enter your password ", Toast.LENGTH_SHORT).show();

        }
        else{

            loadingBar.setTitle("Log in");
            loadingBar.setMessage("please wait untill log in................");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        sendUserToMainActivity();
                        Toast.makeText(LoginActivity.this, "your are logged in successfully", Toast.LENGTH_SHORT).show();
                    }else {
                        String message=task.getException().getMessage();
                        Toast.makeText(LoginActivity.this, "Error..."+message, Toast.LENGTH_LONG).show();
                    }

                }
            });

        }
    }

    private void sendUserToMainActivity() {

        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser!=null){
            sendUserToMainActivity();
        }
    }
}
