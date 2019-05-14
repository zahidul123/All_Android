package com.example.destroy.rochonabali;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Show_rabindranath extends AppCompatActivity {

    private WebView myWebView;
    private WebSettings webSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rabindranath);

        String vcheck=getIntent().getStringExtra("bangladesh");
        myWebView=findViewById(R.id.showrabin);

        if(vcheck.equals("1")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.rabindra-rachanabali.nltr.org/node/6582");
            myWebView.setWebViewClient(new WebViewClient());

        }else if(vcheck.equals("2")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.rabindra-rachanabali.nltr.org/node/6585");
            myWebView.setWebViewClient(new WebViewClient());


        }else if(vcheck.equals("3")){

            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.rabindra-rachanabali.nltr.org/node/6585");
            myWebView.setWebViewClient(new WebViewClient());


        }else if(vcheck.equals("4")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.rabindra-rachanabali.nltr.org/node/8347");
            myWebView.setWebViewClient(new WebViewClient());

        }else if(vcheck.equals("5")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.rabindra-rachanabali.nltr.org/node/10609");
            myWebView.setWebViewClient(new WebViewClient());

        }else if(vcheck.equals("6")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.rabindra-rachanabali.nltr.org/node/6583");
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
