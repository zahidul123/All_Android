package com.example.destroy.textualapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button sregbtn;
    private Button sallreadyreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        sregbtn=(Button)findViewById(R.id.start_reg_btn);
        sallreadyreg=(Button)findViewById(R.id.start_have_acc);

        sregbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg_intent=new Intent(StartActivity.this,RegisterActivity.class);
                startActivity(reg_intent);
                finish();
            }
        });


        sallreadyreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent al_int=new Intent(StartActivity.this,loginActivity.class);
                startActivity(al_int);
                finish();
            }
        });
    }
}
