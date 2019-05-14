package com.example.destroy.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView wview=(WebView)findViewById(R.id.web);
        wview.loadUrl("https://www.youtube.com/");
        wview.getSettings().setJavaScriptEnabled(true);
        wview.setWebViewClient(new WebViewClient());
    }
}
