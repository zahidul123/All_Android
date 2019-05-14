package com.example.destroy.mailm;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText eto;
    EditText esub;
    EditText ebody;
   Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eto=(EditText)findViewById(R.id.to);
        esub=(EditText)findViewById(R.id.sub);
        ebody=(EditText)findViewById(R.id.body);
        btn=(Button)findViewById(R.id.img);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // Log.i("send mail",null);
                String st=eto.getText().toString();
                String sb=esub.getText().toString();
                String bd=ebody.getText().toString();
               String[] CC = {""};
                Intent email=new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.setType("message/rfc822");


                email.putExtra(Intent.EXTRA_EMAIL,new String[]{st});
               email.putExtra(Intent.EXTRA_CC, CC);
                email.putExtra(Intent.EXTRA_SUBJECT,sb);
                email.putExtra(Intent.EXTRA_TEXT,bd);


                try {

                    startActivity(Intent.createChooser(email,"choose an email client :"));
                   //finish();
                   // Log.i("finish send","");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }




            }
        });
    }
}
