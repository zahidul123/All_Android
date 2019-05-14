package com.example.destroy.shoppayable;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Databasehelper databasehelper;

    private Button show;

   private ListView customerlv;
   private ArrayList<CustomerDetail>customerlist;
   private CustomAdepterForListView customAdepterForListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show=findViewById(R.id.button2);
        customerlv=findViewById(R.id.itemshow);


        databasehelper=new Databasehelper(MainActivity.this);
        final SQLiteDatabase sqLiteDatabase=databasehelper.getWritableDatabase();

        customerlist=new ArrayList<>();
        ArrayList<String>custome=new ArrayList<>();
        Cursor cursor=databasehelper.displayalldata();
        if (cursor.moveToFirst()){
            do{
                int id=cursor.getInt(cursor.getColumnIndex(Databasehelper.id));
                String name=cursor.getString(cursor.getColumnIndex(Databasehelper.name));
                String email=cursor.getString(cursor.getColumnIndex(Databasehelper.email));
                String phone=cursor.getString(cursor.getColumnIndex(Databasehelper.phpne));
                CustomerDetail customerDetail=new CustomerDetail(id,name,email,phone);
                customerlist.add(customerDetail);
            }while(cursor.moveToNext());
            sqLiteDatabase.close();

        }
        /*
        for (CustomerDetail value:customerlist){
            custome.add(value.getCname()+" "+value.getEmail()+" "+value.getCphone());
        }

        ArrayAdapter<String>showlist=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,custome);
        customerlv.setAdapter(showlist);
*/

        customAdepterForListView=new CustomAdepterForListView(this,customerlist);
        customerlv.setAdapter(customAdepterForListView);


        customerlv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(MainActivity.this,PersonUpdate.class);
                intent.putExtra("id",customerlist.get(position).getId());
                startActivity(intent);
                return true;
            }
        });

       show.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

              // CustomerDetail customerDet=new CustomerDetail();
               Intent intent =new Intent(MainActivity.this,Addperson.class);
               startActivity(intent);
               finish();

           }
       });

    }
}

