package com.example.destroy.rochonabali;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Show_bonkim extends AppCompatActivity {

    private WebView myWebView;
    private WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bonkim);


        String vcheck=getIntent().getStringExtra("bangladesh");
        myWebView=findViewById(R.id.showbankim);


        if(vcheck.equals("1")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.bankim.rachanabali.nltr.org/node/69");
            myWebView.setWebViewClient(new WebViewClient());

        }else if(vcheck.equals("2")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.bankim.rachanabali.nltr.org/node/1145");
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
