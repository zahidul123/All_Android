package com.example.destroy.rochonabali;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Show_nazrul extends AppCompatActivity {

    private WebView myWebView;
    private WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_nazrul);

        String vcheck=getIntent().getStringExtra("bangladesh");
        myWebView=findViewById(R.id.shownazrul);

        if(vcheck.equals("1")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.nazrul.rachanabali.nltr.org/rachanasamargrasub.php?catid=1");
            myWebView.setWebViewClient(new WebViewClient());

        }else if(vcheck.equals("2")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.nazrul.rachanabali.nltr.org/rachanasamargrasub.php?catid=6");
            myWebView.setWebViewClient(new WebViewClient());


        }else if(vcheck.equals("3")){

            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.nazrul.rachanabali.nltr.org/rachanasamargrasub.php?catid=2");
            myWebView.setWebViewClient(new WebViewClient());


        }else if(vcheck.equals("4")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.nazrul.rachanabali.nltr.org/rachanasamargrasub.php?catid=4");
            myWebView.setWebViewClient(new WebViewClient());

        }else if(vcheck.equals("5")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.nazrul.rachanabali.nltr.org/rachanasamargrasub.php?catid=5");
            myWebView.setWebViewClient(new WebViewClient());

        }else if(vcheck.equals("6")){
            webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("http://www.nazrul.rachanabali.nltr.org/rachanasamargrasub.php?catid=3");
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

