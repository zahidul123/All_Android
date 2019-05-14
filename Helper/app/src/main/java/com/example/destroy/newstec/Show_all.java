package com.example.destroy.newstec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.destroy.helper.R;

public class Show_all extends AppCompatActivity {

    private WebView myWebView;
    private WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        String vcheck=getIntent().getStringExtra("bangladesh");
        myWebView=findViewById(R.id.entertainer);

        if(vcheck.equals("1")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.prothomalo.com/");
            myWebView.setWebViewClient(new WebViewClient());

        }else if(vcheck.equals("2")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("https://www.jugantor.com/");
            myWebView.setWebViewClient(new WebViewClient());


        }else if(vcheck.equals("3")){

            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.kalerkantho.com/");
            myWebView.setWebViewClient(new WebViewClient());


        }else if(vcheck.equals("4")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.thedailystar.net/");
            myWebView.setWebViewClient(new WebViewClient());

        }else if(vcheck.equals("5")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://samakal.com/");
            myWebView.setWebViewClient(new WebViewClient());

        }else if(vcheck.equals("6")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.ittefaq.com.bd/");
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
