package com.example.destroy.workfragement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showfragement(View view) {
        Fragment fragment;

         if(view==findViewById(R.id.btna)){
            fragment=new fragA();
          FragmentManager fm=getSupportFragmentManager();
          FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fragementshow,fragment);
            ft.commit();
        }


        if(view==findViewById(R.id.btnb)){
            fragment=new FragB();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fragementshow,fragment);
            ft.commit();
        }

          if (view == findViewById(R.id.btnc)) {
              fragment = new FragC();
              FragmentManager fm = getSupportFragmentManager();
              FragmentTransaction ft = fm.beginTransaction();
              ft.replace(R.id.fragementshow, fragment);
              ft.commit();
          }

        if(view==findViewById(R.id.btnd)){
            fragment=new FragD();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fragementshow,fragment);
            ft.commit();
        }
        if(view==findViewById(R.id.btne)){
            fragment=new FragE();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fragementshow,fragment);
            ft.commit();
        }
        if(view==findViewById(R.id.btnf)){
            fragment=new FragF();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fragementshow,fragment);
            ft.commit();
        }
        if(view==findViewById(R.id.btnh)){
            fragment=new FragG();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fragementshow,fragment);
            ft.commit();
        }
        if(view==findViewById(R.id.btni)){
            fragment=new FragH();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fragementshow,fragment);
            ft.commit();
        }



    }
}
