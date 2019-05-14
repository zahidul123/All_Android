package com.example.destroy.phoecall_by_phonebook;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private EditText mEditTextNumber;
    ImageView imageCall;
    ListView listView;
    String name,num;
    ArrayList<String>contacts=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextNumber = findViewById(R.id.edit_text_number);
        imageCall = findViewById(R.id.image_call);
        listView=(ListView)findViewById(R.id.showcalllist);

        mEditTextNumber.setVisibility(View.INVISIBLE);
        imageCall.setVisibility(View.INVISIBLE);
        fetchcontacts();



    }

    public void fetchcontacts() {


        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;



        final String [] projection={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
        String selection=null;
        String [] selectionarguments=null;
        String sortin=null;

        ContentResolver resolver=getContentResolver();
       Cursor cursor= resolver.query(uri,projection,selection,selectionarguments,sortin);

       while (cursor.moveToNext()){
            name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            num=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
           //Log.i("phonebook","Name "+name+"number "+num);

           contacts.add(name+"\n"+num);
       }

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,contacts));


     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


             mEditTextNumber.setVisibility(View.VISIBLE);
             imageCall.setVisibility(View.VISIBLE);
             listView.setVisibility(View.INVISIBLE);

             String getdetails= contacts.get(i);
             String part[]=getdetails.split("\n");

            // Toast.makeText(MainActivity.this,part[1], Toast.LENGTH_SHORT).show();


             mEditTextNumber.setText(part[1]);
             imageCall.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     makePhoneCall();
                 }
             });

         }
     });


    }

    private void makePhoneCall() {
        String number = mEditTextNumber.getText().toString();
        if (number.trim().length() > 0) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(intent);

        }

    }

}
