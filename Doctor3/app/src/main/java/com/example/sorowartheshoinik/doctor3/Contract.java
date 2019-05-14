package com.example.sorowartheshoinik.doctor3;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Contract extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);


        Button btn1 = (Button)findViewById(R.id.btnSetEmargency);

      //  btn1.setOnClickListener(new View.OnClickListener() {
      //      @Override
     //       public void onClick(View v) {
     //           BtnSetEmargency_onClick(null);
    //        }
     //   });

        Button btn2 = (Button)findViewById(R.id.btnEmail);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_onClick(null);
            }
        });

        Button startBtn = (Button) findViewById(R.id.btnSMS);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendSMS(null);
            }
        });
    }






  /*  public void BtnSetEmargency_onClick(View view){
        String number = "01780101357";
        Intent intent= new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+ number));

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){

            return;

        }
        startActivity(intent);
    }

*/

    public void button_onClick(View view){
        String email = "Ghoreberdaktar@gmail.com";
        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {email});
        try {
            startActivity(intent);
        } catch(ActivityNotFoundException ex) {
            Toast.makeText(Contract.this, "No Default Email app found in you device, install Email app to continue", Toast.LENGTH_SHORT).show();
        }
    }


    public void sendSMS(Object o) {
        Log.i("Send SMS", "");
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);

        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address"  , new String ("01780101357"));
        smsIntent.putExtra("sms_body"  , "Ghoreber Daktar ");

        try {
            startActivity(smsIntent);
            finish();
            Log.i("Finished sending SMS...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Contract.this, "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }
}
