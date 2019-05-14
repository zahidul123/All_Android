package com.example.destroy.newstec;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.example.destroy.helper.R;

public class ProgrammingActivity extends AppCompatActivity  {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle action;
    private Toolbar mtoolbar;
    private NavigationView navigationView;
    private LinearLayout layout;
    private WebView myWebView;
    private WebSettings webSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming);

        mtoolbar=(Toolbar)findViewById(R.id.programmingtoolbars);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("Programming is Fun");

        drawer=findViewById(R.id.drawetoweb);
        action=new ActionBarDrawerToggle(ProgrammingActivity.this,drawer,R.string.open,R.string.close);
        navigationView=(NavigationView)findViewById(R.id.nav_prog);


       myWebView=findViewById(R.id.programminglink);


        drawer.addDrawerListener(action);
        action.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         layout=(LinearLayout)findViewById(R.id.wwe);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.cprogramming){

                    layout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("https://www.programiz.com/c-programming#tutorial");
                    myWebView.setWebViewClient(new WebViewClient());
                }

                if (item.getItemId()==R.id.csharp){
                    layout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("http://www.learncs.org/");
                    myWebView.setWebViewClient(new WebViewClient());

                }

                if (item.getItemId()==R.id.dotnet){
                    layout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("http://www.tutorialspoint.com/asp.net/");
                    myWebView.setWebViewClient(new WebViewClient());
                }

                if (item.getItemId()==R.id.java){
                    layout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("https://www.javatpoint.com/java-tutorial");
                    myWebView.setWebViewClient(new WebViewClient());
                }

                if (item.getItemId()==R.id.php){
                    layout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("http://www.php.net/");
                    myWebView.setWebViewClient(new WebViewClient());
                }

                if (item.getItemId()==R.id.python){
                    layout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("http://www.anandabazar.com/?ref=hm-Brandlogo");
                    myWebView.setWebViewClient(new WebViewClient());
                }

                if (item.getItemId()==R.id.javascript){
                    layout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("https://www.javascript.com/learn/javascript/strings");
                    myWebView.setWebViewClient(new WebViewClient());
                }

                if (item.getItemId()==R.id.swift){
                    layout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("https://developer.apple.com/documentation/");
                    myWebView.setWebViewClient(new WebViewClient());
                }

                if (item.getItemId()==R.id.cplus){
                    layout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("http://www.cplusplus.com/doc/tutorial/");
                    myWebView.setWebViewClient(new WebViewClient());
                }

                if (item.getItemId()==R.id.database){

                    layout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("https://www.w3schools.com/sql/sql_drop_db.asp");
                    myWebView.setWebViewClient(new WebViewClient());
                }

                return false;
            }
        });

    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (action.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}
