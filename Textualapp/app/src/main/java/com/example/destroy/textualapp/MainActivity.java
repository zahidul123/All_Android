package com.example.destroy.textualapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewParent;
import android.widget.TableLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

public class MainActivity extends AppCompatActivity {


    private Toolbar mtoolbar;
    private FirebaseAuth mAuth;
    private DatabaseReference muserRefe;

    private ViewPager viewpage;
    private SectionPagerAdapter sectionPagerAdapter;
    private TabLayout mtabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mtoolbar=(Toolbar)findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("TextUalApp");

        if (mAuth.getCurrentUser()!=null) {

            muserRefe = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getCurrentUser().getUid());
        }

        // tabs

        viewpage=(ViewPager)findViewById(R.id.tabpager);

        sectionPagerAdapter=new SectionPagerAdapter(getSupportFragmentManager());
        viewpage.setAdapter(sectionPagerAdapter);

        mtabLayout=(TabLayout)findViewById(R.id.main_tabs);
        mtabLayout.setupWithViewPager(viewpage);


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser==null){
            senttostart();
        }else{
            muserRefe.child("online").setValue("true");

        }
    }

    protected void onStop() {

        super.onStop();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null) {
            muserRefe.child("online").setValue(ServerValue.TIMESTAMP);
           // muserRefe.child("last seen").setValue(ServerValue.TIMESTAMP);
        }

    }


    private void senttostart() {
        Intent main_intent=new Intent(MainActivity.this,StartActivity.class);
        startActivity(main_intent);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
         getMenuInflater().inflate(R.menu.main_menu,menu);
         return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);
         if (item.getItemId()==R.id.main_logout_btn){
             FirebaseAuth.getInstance().signOut();
             senttostart();
         }
         if (item.getItemId()==R.id.main_setting_btn){
             Intent settingint=new Intent(MainActivity.this,SettingActivity.class);
             startActivity(settingint);
         }
         if (item.getItemId()==R.id.main_alluser_btn){
             Intent settingint=new Intent(MainActivity.this,UsersActivity.class);
             startActivity(settingint);
         }
         return true;
    }
}
