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

public class Govment_Activity extends AppCompatActivity {
    private DrawerLayout gdrawer;
    private ActionBarDrawerToggle gaction;
    private Toolbar gmtoolbar;
    private NavigationView gnavigationView;
    private LinearLayout glayout;
    private WebView myWebView;
    private WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govment_);


        gmtoolbar=(Toolbar)findViewById(R.id.govmentd);
        setSupportActionBar(gmtoolbar);
        getSupportActionBar().setTitle("Bangladesh");

        gdrawer=findViewById(R.id.govmentsearch);
        gaction=new ActionBarDrawerToggle(Govment_Activity.this,gdrawer,R.string.open,R.string.close);
        gnavigationView=(NavigationView)findViewById(R.id.nav_gov);


        myWebView=findViewById(R.id.allgovmentweb);


        gdrawer.addDrawerListener(gaction);
        gaction.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        glayout=(LinearLayout)findViewById(R.id.wwwe);

        gnavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.railway){

                    glayout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("https://www.esheba.cnsbd.com/");
                    myWebView.setWebViewClient(new WebViewClient());
                }

               else if (item.getItemId()==R.id.ninfocenter){
                    glayout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("http://www.bangladesh.gov.bd/");
                    myWebView.setWebViewClient(new WebViewClient());

                }

               else if (item.getItemId()==R.id.ministryofinfo){
                    glayout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("http://www.moi.gov.bd/");
                    myWebView.setWebViewClient(new WebViewClient());
                }

               else if (item.getItemId()==R.id.minedu){
                    glayout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("http://www.moedu.gov.bd/");
                    myWebView.setWebViewClient(new WebViewClient());
                }

               else if (item.getItemId()==R.id.ictdiv){
                    glayout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("http://www.ictd.gov.bd/");
                    myWebView.setWebViewClient(new WebViewClient());
                }

               else if (item.getItemId()==R.id.atoi){
                    glayout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("http://a2i.pmo.gov.bd/");
                    myWebView.setWebViewClient(new WebViewClient());
                }

               else if (item.getItemId()==R.id.jobsbd){
                    glayout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("http://jobsbd.com/");
                    myWebView.setWebViewClient(new WebViewClient());
                }

                else if (item.getItemId()==R.id.bdjobs){
                    glayout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("http://www.bdjobs.com/");
                    myWebView.setWebViewClient(new WebViewClient());
                }

                else if (item.getItemId()==R.id.chakri){
                    glayout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("http://www.chakri.com/");
                    myWebView.setWebViewClient(new WebViewClient());
                }

                else if (item.getItemId()==R.id.jobcirular){

                    glayout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("https://jobscircular24.com/prothom-alo-newspaper-jobs-circular/");
                    myWebView.setWebViewClient(new WebViewClient());
                }
               else if (item.getItemId()==R.id.govtjob){

                    glayout.setVisibility(View.VISIBLE);
                    webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl("http://bangladesh.gov.bd/site/view/job_category");
                    myWebView.setWebViewClient(new WebViewClient());
                }

                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (gaction.onOptionsItemSelected(item)){
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
