package com.example.admin.frag;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void er(View view){
        if(view==findViewById(R.id.button)){
            fragment = new Day1();




        }
        if(view==findViewById(R.id.button2)){
            fragment = new Day2();}
        if(view==findViewById(R.id.button3)){
            fragment = new Day3();}



            FragmentManager fm=getFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fragment, fragment);

            ft.commit();

    }

}
