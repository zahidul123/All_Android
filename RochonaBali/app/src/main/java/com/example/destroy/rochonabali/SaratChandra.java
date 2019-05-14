package com.example.destroy.rochonabali;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class SaratChandra extends AppCompatActivity {
    private CardView prothoalo,juganto,kalrkontho,somkal,dailstar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sarat_chandra);

        prothoalo=findViewById(R.id.snovel);
        juganto=findViewById(R.id.srochona);
        kalrkontho=findViewById(R.id.sartical);
        somkal=findViewById(R.id.sstory);
        dailstar=findViewById(R.id.snatok);





        prothoalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SaratChandra.this,Show_sharat.class);
                intent.putExtra("bangladesh","1");
                startActivity(intent);



            }
        });

        juganto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(SaratChandra.this,Show_sharat.class);
                intent.putExtra("bangladesh","2");
                startActivity(intent);



            }
        });


        kalrkontho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(SaratChandra.this,Show_sharat.class);
                intent.putExtra("bangladesh","3");
                startActivity(intent);


            }
        });


        dailstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(SaratChandra.this,Show_sharat.class);
                intent.putExtra("bangladesh","4");
                startActivity(intent);


            }
        });


        somkal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(SaratChandra.this,Show_sharat.class);
                intent.putExtra("bangladesh","5");
                startActivity(intent);


            }
        });

    }
}
