package com.example.destroy.newstec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.destroy.helper.R;

public class All_Paper_Activity extends AppCompatActivity {
    private Button bangla,world;

    private Toolbar mbtoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__paper_);
        bangla=findViewById(R.id.bangladeshi);
        world=findViewById(R.id.world);

        mbtoolbar=(Toolbar)findViewById(R.id.allpaper);
        setSupportActionBar(mbtoolbar);
        getSupportActionBar().setTitle("   সংবাদপত্র");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void fragement(View view) {


        if(view==bangla){
            Intent intent=new Intent(All_Paper_Activity.this,Bangladeshi_papers.class);
           // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
           // finish();
        }
        if (view==world){
            Intent intent=new Intent(All_Paper_Activity.this,World_famous_paper.class);
           // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
           // finish();
        }
    }
}
