package com.example.destroy.textualapp;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class StatusActivity extends AppCompatActivity {

    private Toolbar mtoolbar;
    private TextInputLayout mstatus;
    private Button msavebtn;

    ///firebase
    private DatabaseReference mdbreference;
    private FirebaseUser mcurrentuser;

    //progress
    private ProgressDialog mprogress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);



        mtoolbar=(Toolbar)findViewById(R.id.status_appbar);
       setSupportActionBar(mtoolbar);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       //firebase user references...
         mcurrentuser=FirebaseAuth.getInstance().getCurrentUser();
         String uid=mcurrentuser.getUid();
         mdbreference=FirebaseDatabase.getInstance().getReference().child("Users").child(uid);



       mstatus=(TextInputLayout)findViewById(R.id.status_input);
       msavebtn=(Button)findViewById(R.id.status_save_btn);


       //passing value from one intent to another and set here
       String status_value=getIntent().getStringExtra("status_value");
       mstatus.getEditText().setText(status_value);

      msavebtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              //progress
              mprogress=new ProgressDialog(StatusActivity.this);
              mprogress.setTitle("saving change");
              mprogress.setMessage("please wait while status changing");
              mprogress.show();

              String input=mstatus.getEditText().getText().toString();
              mdbreference.child("status").setValue(input).addOnCompleteListener(new OnCompleteListener<Void>() {
                  @Override
                  public void onComplete(@NonNull Task<Void> task) {
                      if (task.isSuccessful()){
                          mprogress.dismiss();
                      }else{

                      }
                  }
              });
              Toast.makeText(StatusActivity.this,input,Toast.LENGTH_LONG).show();
          }
      });
    }
}
