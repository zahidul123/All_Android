package com.example.destroy.newstec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.destroy.helper.R;

public class MainActivity extends AppCompatActivity {
   // private WebView myWebView;
    private CardView paper,govtsite,programming,entertainment,health;
 private Toolbar mltoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  myWebView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://www.youtube.com/");
        myWebView.setWebViewClient(new WebViewClient());
*/
       mltoolbar=(Toolbar)findViewById(R.id.maintoolbar);
       setSupportActionBar(mltoolbar);
       getSupportActionBar().setTitle("       অনুসন্ধানী  ");

        paper=(CardView)findViewById(R.id.main_paper);
        govtsite=(CardView)findViewById(R.id.main_govmentsite);
        programming=(CardView)findViewById(R.id.main_programming);
        entertainment=(CardView)findViewById(R.id.Main_Entertainment);
        health=(CardView)findViewById(R.id.Main_dosctor);
        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,EntertainmentActivity.class);
                startActivity(intent);

            }
        });

        govtsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Govment_Activity.class);
                startActivity(intent);

            }
        });


        programming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ProgrammingActivity.class);
                startActivity(intent);

            }
        });


        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,All_Paper_Activity.class);
                startActivity(intent);

            }
        });



        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,HealthActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_resource,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.help){
            Intent intent=new Intent(MainActivity.this,HelpOfphone.class);
            startActivity(intent);
        }
       else if (id==R.id.about){
            Intent intents=new Intent(MainActivity.this,Aboutme.class);
            startActivity(intents);

        }
        return super.onOptionsItemSelected(item);
    }
}
