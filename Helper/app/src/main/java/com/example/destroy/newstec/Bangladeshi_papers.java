package com.example.destroy.newstec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.destroy.helper.R;

public class Bangladeshi_papers extends AppCompatActivity {

 private CardView prothoalo,juganto,kalrkontho,somkal,dailstar,itefaq;
 private Toolbar btoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangladeshi_papers);


        prothoalo=findViewById(R.id.protonalo);
        juganto=findViewById(R.id.jugantor);
        kalrkontho=findViewById(R.id.kalerkontho);
        somkal=findViewById(R.id.somokal);
        dailstar=findViewById(R.id.dailystar);
        itefaq=findViewById(R.id.ittefaq);

        btoolbar=(Toolbar)findViewById(R.id.prottika);
        setSupportActionBar(btoolbar);
        getSupportActionBar().setTitle("বাংলাদেশী সংবাদপত্র");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



       prothoalo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(Bangladeshi_papers.this,Show_all.class);
               intent.putExtra("bangladesh","1");
               startActivity(intent);



           }
       });

        juganto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Bangladeshi_papers.this,Show_all.class);
                intent.putExtra("bangladesh","2");
                startActivity(intent);



            }
        });


        kalrkontho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Bangladeshi_papers.this,Show_all.class);
                intent.putExtra("bangladesh","3");
                startActivity(intent);


            }
        });


        dailstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Bangladeshi_papers.this,Show_all.class);
                intent.putExtra("bangladesh","4");
                startActivity(intent);


            }
        });


        somkal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(Bangladeshi_papers.this,Show_all.class);
                intent.putExtra("bangladesh","5");
                startActivity(intent);


            }
        });


        itefaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Bangladeshi_papers.this,Show_all.class);
                intent.putExtra("bangladesh","6");
                startActivity(intent);


            }
        });

    }

}
