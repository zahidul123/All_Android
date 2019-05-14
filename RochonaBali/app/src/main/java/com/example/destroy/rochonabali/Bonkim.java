package com.example.destroy.rochonabali;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Bonkim extends AppCompatActivity {
    private CardView prothoalo,juganto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonkim);

        prothoalo=findViewById(R.id.bnovel);
        juganto=findViewById(R.id.bgoddo);


        prothoalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Bonkim.this,Show_bonkim.class);
                intent.putExtra("bangladesh","1");
                startActivity(intent);


            }
        });

        juganto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Bonkim.this,Show_bonkim.class);
                intent.putExtra("bangladesh","2");
                startActivity(intent);



            }
        });

    }


}
