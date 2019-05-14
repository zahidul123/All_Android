package com.example.destroy.newstec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.destroy.helper.R;

public class show_world_paper extends AppCompatActivity {
    private WebView myWebView;
    private WebSettings webSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_world_paper);

        String vcheck=getIntent().getStringExtra("bangladesh");
        myWebView=findViewById(R.id.worldfamous);


        if(vcheck.equals("1")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.anandabazar.com/?ref=hm-Brandlogo");
            myWebView.setWebViewClient(new WebViewClient());

        }else if(vcheck.equals("2")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("https://www.usatoday.com/news/");
            myWebView.setWebViewClient(new WebViewClient());


        }else if(vcheck.equals("3")){

            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("https://tribune.com.pk/");
            myWebView.setWebViewClient(new WebViewClient());


        }else if(vcheck.equals("4")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("https://www.aajkaal.in/");
            myWebView.setWebViewClient(new WebViewClient());

        }else if(vcheck.equals("5")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("https://timesofindia.indiatimes.com/defaultinterstitial.cms");
            myWebView.setWebViewClient(new WebViewClient());

        }else if(vcheck.equals("6")){

            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("https://www.independent.co.uk/?CMP=ILC-refresh");
            myWebView.setWebViewClient(new WebViewClient());

        }
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
