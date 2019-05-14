package com.example.sorowartheshoinik.doctor3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class done extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
    }

    public void b1(View view)
    {
        Intent intent=new Intent(this,done1.class);
        startActivities(new Intent[]{intent});
    }

    public void b2(View view)
    {
        Intent intent=new Intent(this,done2.class);
        startActivities(new Intent[]{intent});
    }

    public void b3(View view)
    {
        Intent intent=new Intent(this,done3.class);
        startActivities(new Intent[]{intent});
    }
    public void b4(View view)
    {
        Intent intent=new Intent(this,done4.class);
        startActivities(new Intent[]{intent});
    }
    public void b5(View view)
    {
        Intent intent=new Intent(this,done5.class);
        startActivities(new Intent[]{intent});
    }
}
