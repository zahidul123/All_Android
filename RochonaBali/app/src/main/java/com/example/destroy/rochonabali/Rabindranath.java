package com.example.destroy.rochonabali;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Rabindranath extends AppCompatActivity {
    private CardView prothoalo,juganto,kalrkontho,somkal,dailstar,itefaq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabindranath);


        prothoalo=findViewById(R.id.rnovel);
        juganto=findViewById(R.id.rsong);
        kalrkontho=findViewById(R.id.rstory);
        somkal=findViewById(R.id.rpoem);
        dailstar=findViewById(R.id.rartical);
        itefaq=findViewById(R.id.rnatok);




        prothoalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Rabindranath.this,Show_rabindranath.class);
                intent.putExtra("bangladesh","1");
                startActivity(intent);



            }
        });

        juganto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Rabindranath.this,Show_rabindranath.class);
                intent.putExtra("bangladesh","2");
                startActivity(intent);



            }
        });


        kalrkontho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Rabindranath.this,Show_rabindranath.class);
                intent.putExtra("bangladesh","3");
                startActivity(intent);


            }
        });


        dailstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Rabindranath.this,Show_rabindranath.class);
                intent.putExtra("bangladesh","4");
                startActivity(intent);


            }
        });


        somkal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(Rabindranath.this,Show_rabindranath.class);
                intent.putExtra("bangladesh","5");
                startActivity(intent);


            }
        });


        itefaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Rabindranath.this,Show_rabindranath.class);
                intent.putExtra("bangladesh","6");
                startActivity(intent);


            }
        });

    }
}
