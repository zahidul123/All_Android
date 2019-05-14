package com.example.destroy.shoppayable;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addperson extends AppCompatActivity {

    Databasehelper databasehelper;

    private EditText name,email,phone;
    private Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addperson);

        name=findViewById(R.id.editText);
        email=findViewById(R.id.editText2);
        phone=findViewById(R.id.editText3);

        add=findViewById(R.id.button);
        databasehelper=new Databasehelper(Addperson.this);
        final SQLiteDatabase sqLiteDatabase=databasehelper.getWritableDatabase();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gname = name.getText().toString().trim();
                String gemail = email.getText().toString().trim();
                String gphone = phone.getText().toString().trim();
                if (gname.equals("") || gemail.equals("") || gphone.equals("")) {
                    if (gname.equals(null)) {
                        name.setHint("please fill this ");
                    }
                    if (gemail.equals(null)) {
                        name.setHint("please fill this ");
                    }
                    if (gphone.equals(null)) {
                        name.setHint("please fill this ");
                    }
                } else {
                    long rowid = databasehelper.insertdata(gname, gemail, gphone);
                    if (rowid > 0) {
                        Intent intent =new Intent(Addperson.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                        Toast.makeText(Addperson.this, rowid + " Row is successfully inserted ", Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(Addperson.this, " Row is not successfully inserted ", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
}
