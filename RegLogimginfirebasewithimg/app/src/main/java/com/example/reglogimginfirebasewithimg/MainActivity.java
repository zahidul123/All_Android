package com.example.reglogimginfirebasewithimg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  private Button admin,user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        admin=findViewById(R.id.admin);
        user=findViewById(R.id.user);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,adminregistration.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"admin class",Toast.LENGTH_SHORT).show();
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,userregistration.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"user class",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
