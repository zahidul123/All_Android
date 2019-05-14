package com.example.destroy.rochonabali;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Show_sharat extends AppCompatActivity {
    private WebView myWebView;
    private WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sharat);


        String vcheck=getIntent().getStringExtra("bangladesh");
        myWebView=findViewById(R.id.showsaratlo);

        if(vcheck.equals("1")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.sarat-rachanabali.nltr.org/subCat.jsp?001");
            myWebView.setWebViewClient(new WebViewClient());

        }else if(vcheck.equals("2")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.sarat-rachanabali.nltr.org/subCat.jsp?005");
            myWebView.setWebViewClient(new WebViewClient());


        }else if(vcheck.equals("3")){

            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.sarat-rachanabali.nltr.org/subCat.jsp?004");
            myWebView.setWebViewClient(new WebViewClient());


        }else if(vcheck.equals("4")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.sarat-rachanabali.nltr.org/subCat.jsp?003");
            myWebView.setWebViewClient(new WebViewClient());

        }else if(vcheck.equals("5")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.sarat-rachanabali.nltr.org/subCat.jsp?002");
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
