package com.example.destroy.emailem;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void hope(View view){
        Intent brow=new Intent(Intent.ACTION_VIEW, Uri.parse("http://epaper.prothom-alo.com/"));
        startActivity(brow);
        Toast ts=Toast.makeText(this,"you are in prothom alo",Toast.LENGTH_SHORT);
        ts.show();

    }
}
