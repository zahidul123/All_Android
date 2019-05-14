package com.example.destroy.streetfriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BusSelection extends AppCompatActivity {
    private String [] airazim={"Bekash","VIP-27"};
    private String [] airbad={"motizil-banani","Bondhu"};
    private String [] kombad={"Brtc","Lamiya"};
    private String [] agarkom={"Ayeat"};
    private String [] kalaazim={"Asirbad","VIP-27","thikana","savarParibahan","shefty","Behongo","Mirpurlink","dlink"};
    private String [] gabazim={"thikana","savarParibahan","shefty","Dlink"};
    private String [] mirazim={"Asirbad","Behongo"};
    private String [] kalagul={"7nong","Transilva","shuvesha"};
    private String [] gabgul={"7nong","shuvesha"};
    private String [] mirgul={"Khajababa","Desari","Everest"};
    private String [] agargul={"Himachol","Shadhin"};
    private String [] airagar={"Tahmina","Dhunchia"};
    private String [] gabair={"Monisha","Ramzan"};
    private String [] kalaagar={"Citybus","Shefty","Mirpurlink"};
    private String [] kalamir={"Behongo","shuvesha","Everest"};
    private String [] kalagab={"Thikana","DLink","Shaver"};
    private String [] gabkom={"Labyiek"};

    String airazimb,airbadb,kombadb,gabkomb,agarkomb,kalaazimb,gabazimb,mirazimb,kalagulb,gabgulb,mirgulb,agargulb,airagorb,gabairb,kalaagarb,kalamirb,kalagubb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_selection);


        ListView listview = (ListView) findViewById(R.id.busset);


       // if (!getIntent().getStringExtra("airazim").equals("")) {
            airazimb = getIntent().getStringExtra("airazim");
       // }
       //   else if (!getIntent().getStringExtra("airbadd").equals("")) {
            airbadb = getIntent().getStringExtra("airbadd");
       // }
       //else if (!getIntent().getStringExtra("kombad").equals("")) {
            kombadb = getIntent().getStringExtra("kombad");
       // }
       //else if (!getIntent().getStringExtra("kombad").equals("")) {
            gabkomb = getIntent().getStringExtra("kombad");
       // }
       //else if (!getIntent().getStringExtra("agarkom").equals("")){
            agarkomb = getIntent().getStringExtra("agarkom");
   // }
     // else  if (!getIntent().getStringExtra("kalaazim").equals("")){
            kalaazimb = getIntent().getStringExtra("kalaazim");
       // }
       //else if (!getIntent().getStringExtra("gabazim").equals("")){
            gabazimb = getIntent().getStringExtra("gabazim");
     //   }
     // else  if (!getIntent().getStringExtra("mirazim").equals("")) {
            mirazimb = getIntent().getStringExtra("mirazim");
       // }
       //else if (!getIntent().getStringExtra("kalagul").equals("")) {
            kalagulb = getIntent().getStringExtra("kalagul");
     //   }
     //   else if (!getIntent().getStringExtra("gabgul").equals("")){
            gabgulb = getIntent().getStringExtra("gabgul");
      //  }
      // else if (!getIntent().getStringExtra("mirgul").equals("")){
            mirgulb = getIntent().getStringExtra("mirgul");
      //  }
       //else if (!getIntent().getStringExtra("agargul").equals("")){
            agargulb = getIntent().getStringExtra("agargul");
      //  }
    //  else  if (!getIntent().getStringExtra("airgor").equals("")) {
            airagorb = getIntent().getStringExtra("airgor");
       // }
     // else  if (!getIntent().getStringExtra("gabair").equals("")){
            gabairb = getIntent().getStringExtra("gabair");
      //  }
      // else if (!getIntent().getStringExtra("kalaagar").equals("")) {
            kalaagarb = getIntent().getStringExtra("kalaagar");
       // }
      // else if (!getIntent().getStringExtra("kalamir").equals("")){
            kalamirb = getIntent().getStringExtra("kalamir");
      //  }
      // else if (!getIntent().getStringExtra("kalagub").equals("")){
            kalagubb = getIntent().getStringExtra("kalagub");
      //  }

        Toast.makeText(this, ""+airazimb, Toast.LENGTH_SHORT).show();

 if (airazimb.equals("airazim")) {
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,airazim);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

 }
  if (airbadb.equals("airbadd")){
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,airbad);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

  }

  if (kombadb.equals("kombad")){
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,kombad);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

 }

 if (gabkomb.equals("gabkom")){
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,gabkom);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

 }


  if (agarkomb.equals("agarkom")){
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,agarkom);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

 }


  if (kalaazimb.equals("kalaazim")){
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,kalaazim);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

 }


  if (gabazimb.equals("gabazim")){
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,gabazim);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

 }


  if (mirazimb.equals("mirazim")){
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mirazim);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

 }


  if (kalagulb.equals("kalagul")){
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,kalagul);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

 }

 else if (gabgulb.equals("gabgul")){
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,gabgul);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

 }

 else if (mirgulb.equals("mirgul")){
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mirgul);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

 }

 else if (agargulb.equals("agargul")){
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,agargul);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

 }

 else if (airagorb.equals("airagor")){
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,airagar);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

 }


 else if (gabairb.equals("gabair")){
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,gabair);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

 }


if (kalaagarb.equals("kalaagar")){
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,kalaagar);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

 }


 if (kalamirb.equals("kalamir")){
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,kalamir);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

 }

 if (kalagubb.equals("kalagub")){
     ArrayAdapter<String> buslist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,kalagab);

     listview.setAdapter(buslist);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         }
     });

 }





    }
}
