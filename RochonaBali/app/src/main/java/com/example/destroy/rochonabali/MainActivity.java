package com.example.destroy.rochonabali;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView rabcrd,nazrrd,sarcard,bankim,sesumei;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rabcrd=(CardView)findViewById(R.id.rabindranath);
        nazrrd=(CardView)findViewById(R.id.nazrul);
        sarcard=(CardView)findViewById(R.id.sarat);
        bankim=(CardView)findViewById(R.id.bankims);
        sesumei=(CardView)findViewById(R.id.myresume);
        rabcrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rabint=new Intent(MainActivity.this,Rabindranath.class);
                startActivity(rabint);
            }
        });

        nazrrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rabint=new Intent(MainActivity.this,Nazrul.class);
                startActivity(rabint);
            }
        });

        sarcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rabint=new Intent(MainActivity.this,SaratChandra.class);
                startActivity(rabint);
            }
        });

        bankim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rabint=new Intent(MainActivity.this,Bonkim.class);
                startActivity(rabint);
            }
        });


        sesumei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rabint=new Intent(MainActivity.this,Choton.class);
                startActivity(rabint);
            }
        });

    }
}
