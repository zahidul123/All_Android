package com.example.destroy.shoppayable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PersonUpdate extends AppCompatActivity {

    TextView cname,eemail;
    EditText cphone;
   int id;
  private Databasehelper databasehelper;
  private Button updt,ondelet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_update);

        databasehelper=new Databasehelper(this);

        cname=findViewById(R.id.namecus);
        eemail=findViewById(R.id.Emailid);
        cphone=findViewById(R.id.phonenum);

        updt=findViewById(R.id.update);
        ondelet=findViewById(R.id.delete);

        id=getIntent().getIntExtra("id",0);
       CustomerDetail sustomer=databasehelper.getSingleDetails(id);
       cname.setText(sustomer.getCname());
       eemail.setText(sustomer.getEmail());
       cphone.setText(sustomer.getCphone());

       ondelet.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               CustomerDetail cusudel=new CustomerDetail(id,cname.getText().toString(),eemail.getText().toString(),cphone.getText().toString());
               long cusdel=databasehelper.Customerdelete(cusudel);
               if (cusdel>0){
                   Toast.makeText(PersonUpdate.this, "delete success", Toast.LENGTH_SHORT).show();
                   Intent intent=new Intent(PersonUpdate.this,MainActivity.class);
                   startActivity(intent);
                   finish();
               }
           }
       });

    }

    public void OnUpdateList(View view) {

        CustomerDetail cusupdt=new CustomerDetail(id,cname.getText().toString(),eemail.getText().toString(),cphone.getText().toString());
        long databaseupdate=databasehelper.UpdatepersonInfformation(cusupdt);
        if (databaseupdate>0){
            Toast.makeText(this, "update successfully", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(PersonUpdate.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
