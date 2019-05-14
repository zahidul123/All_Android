package com.example.sorowartheshoinik.doctor3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void next(View view)
    {
        Intent intent=new Intent(this,Contract.class);
        startActivities(new Intent[]{intent});
    }

    public void done(View view)
    {
        Intent intent=new Intent(this,Po.class);
        startActivities(new Intent[]{intent});
    }

    public void about(View view)
    {
        Intent intent=new Intent(this,about_us.class);
        startActivities(new Intent[]{intent});
    }

    public void doctor(View view)
    {
        Intent intent=new Intent(this,about_doctor.class);
        startActivities(new Intent[]{intent});
    }


    public void onexit(View view)
    {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
