package com.example.destroy.newstec;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.destroy.helper.R;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class EntertainmentActivity extends AppCompatActivity {
   private CircleMenu circleMenu;
    private WebView myWebView;
   private WebSettings webSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment);

        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);

        myWebView = (WebView)findViewById(R.id.entertainer);
        myWebView.setVisibility(View.GONE);

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.parking, R.drawable.cancel)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.search)
                .addSubMenu(Color.parseColor("#30A400"), R.drawable.facebook)
                .addSubMenu(Color.parseColor("#FF4B32"), R.drawable.cricket)
                .addSubMenu(Color.parseColor("#8A39FF"), R.drawable.soccer)
                .addSubMenu(Color.parseColor("#FF6A00"), R.drawable.television)
                .addSubMenu(Color.parseColor("#FFBF00"),R.drawable.youtube)
                .addSubMenu(Color.parseColor("#0404B4"),R.drawable.google_plus)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {

                    @Override
                    public void onMenuSelected(int index) {
                        switch (index){
                            case 0:
                                myWebView.setVisibility(View.VISIBLE);
                                webSettings = myWebView.getSettings();
                                webSettings.setJavaScriptEnabled(true);
                                myWebView.loadUrl("http://www.freebookspot.es/");
                                myWebView.setWebViewClient(new WebViewClient());
                                Toast.makeText(EntertainmentActivity.this, "book", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                myWebView.setVisibility(View.VISIBLE);
                                webSettings = myWebView.getSettings();
                                webSettings.setJavaScriptEnabled(true);
                                myWebView.loadUrl("https://www.facebook.com/");
                                myWebView.setWebViewClient(new WebViewClient());
                                Toast.makeText(EntertainmentActivity.this, "facebook", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                myWebView.setVisibility(View.VISIBLE);
                                webSettings = myWebView.getSettings();
                                webSettings.setJavaScriptEnabled(true);
                                myWebView.loadUrl("http://www.cricbuzz.com/");
                                myWebView.setWebViewClient(new WebViewClient());
                                Toast.makeText(EntertainmentActivity.this, "Cricket", Toast.LENGTH_SHORT).show();
                                break;
                            case 3:
                                myWebView.setVisibility(View.VISIBLE);
                                webSettings = myWebView.getSettings();
                                webSettings.setJavaScriptEnabled(true);
                                myWebView.loadUrl("http://www.espn.in/football/scoreboard");
                                myWebView.setWebViewClient(new WebViewClient());
                                Toast.makeText(EntertainmentActivity.this, "football", Toast.LENGTH_SHORT).show();
                                break;
                            case 4:
                                myWebView.setVisibility(View.VISIBLE);
                                webSettings = myWebView.getSettings();
                                webSettings.setJavaScriptEnabled(true);
                                myWebView.loadUrl("https://www.bioscopelive.com/");
                                myWebView.setWebViewClient(new WebViewClient());
                                Toast.makeText(EntertainmentActivity.this, "television", Toast.LENGTH_SHORT).show();
                                break;
                            case 5:
                                myWebView.setVisibility(View.VISIBLE);
                                webSettings = myWebView.getSettings();
                                webSettings.setJavaScriptEnabled(true);
                                myWebView.loadUrl("https://www.youtube.com/");
                                myWebView.setWebViewClient(new WebViewClient());
                                Toast.makeText(EntertainmentActivity.this, "youtube", Toast.LENGTH_SHORT).show();
                                break;
                            case 6:
                                myWebView.setVisibility(View.VISIBLE);
                                webSettings = myWebView.getSettings();
                                webSettings.setJavaScriptEnabled(true);
                                myWebView.loadUrl("https://accounts.google.com/SignUp?hl=en-GB");
                                myWebView.setWebViewClient(new WebViewClient());
                                Toast.makeText(EntertainmentActivity.this, "google ", Toast.LENGTH_SHORT).show();
                                break;

                        }
                    }

                });

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
