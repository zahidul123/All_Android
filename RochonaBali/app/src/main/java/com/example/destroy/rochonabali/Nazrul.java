package com.example.destroy.rochonabali;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Nazrul extends AppCompatActivity {
    private CardView prothoalo,juganto,kalrkontho,somkal,dailstar,itefaq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nazrul);


        prothoalo=findViewById(R.id.nnovel);
        juganto=findViewById(R.id.nsong);
        kalrkontho=findViewById(R.id.nstory);
        somkal=findViewById(R.id.npoem);
        dailstar=findViewById(R.id.nartical);
        itefaq=findViewById(R.id.nnatok);




        prothoalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Nazrul.this,Show_nazrul.class);
                intent.putExtra("bangladesh","1");
                startActivity(intent);



            }
        });

        juganto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Nazrul.this,Show_nazrul.class);
                intent.putExtra("bangladesh","2");
                startActivity(intent);



            }
        });


        kalrkontho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Nazrul.this,Show_nazrul.class);
                intent.putExtra("bangladesh","3");
                startActivity(intent);


            }
        });


        dailstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Nazrul.this,Show_nazrul.class);
                intent.putExtra("bangladesh","4");
                startActivity(intent);


            }
        });


        somkal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Nazrul.this,Show_nazrul.class);
                intent.putExtra("bangladesh","5");
                startActivity(intent);


            }
        });


        itefaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Nazrul.this,Show_nazrul.class);
                intent.putExtra("bangladesh","6");
                startActivity(intent);


            }
        });

    }
}
