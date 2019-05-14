package com.example.destroy.newstec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.destroy.helper.R;

public class World_famous_paper extends AppCompatActivity {

    private CardView anandobzar,usatday,pakisthi,azkl,indiantime,independnt;
    private Toolbar btoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_famous_paper);

        btoolbar=(Toolbar)findViewById(R.id.worldpaper);
        setSupportActionBar(btoolbar);
        getSupportActionBar().setTitle(" বািশ্বব্যাপী সংবাদপত্র");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        anandobzar=findViewById(R.id.anandobazar);
        usatday=findViewById(R.id.usatoday);
        pakisthi=findViewById(R.id.pakisthani);
        azkl=findViewById(R.id.azkal);
        indiantime=findViewById(R.id.indiantimes);
        independnt=findViewById(R.id.independent);


        anandobzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(World_famous_paper.this,show_world_paper.class);
                intent.putExtra("bangladesh","1");
                startActivity(intent);


            }
        });

        usatday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(World_famous_paper.this,show_world_paper.class);
                intent.putExtra("bangladesh","2");
                startActivity(intent);



            }
        });


        pakisthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(World_famous_paper.this,show_world_paper.class);
                intent.putExtra("bangladesh","3");
                startActivity(intent);


            }
        });


        azkl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(World_famous_paper.this,show_world_paper.class);
                intent.putExtra("bangladesh","4");
                startActivity(intent);


            }
        });


        indiantime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(World_famous_paper.this,show_world_paper.class);
                intent.putExtra("bangladesh","5");
                startActivity(intent);


            }
        });


        independnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(World_famous_paper.this,show_world_paper.class);
                intent.putExtra("bangladesh","6");
                startActivity(intent);


            }
        });


    }


}
