package com.example.destroy.streetfriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  private Spinner spfrom;
  private Spinner spto;
  private ArrayAdapter<CharSequence>fromadp;
  private ArrayAdapter<CharSequence>toadp;
  String onclkfrom,onclkto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spfrom=(Spinner)findViewById(R.id.from);
        spto=(Spinner)findViewById(R.id.to);

        fromadp=ArrayAdapter.createFromResource(this,R.array.root,android.R.layout.simple_spinner_item);
        fromadp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spfrom.setAdapter(fromadp);

        toadp=ArrayAdapter.createFromResource(this,R.array.root,android.R.layout.simple_spinner_item);
        toadp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spto.setAdapter(toadp);

        spfrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               onclkfrom=parent.getItemAtPosition(position).toString();

                Toast.makeText(MainActivity.this, "this"+onclkfrom, Toast.LENGTH_SHORT).show();

               spto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                   @Override
                   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                       onclkto=parent.getItemAtPosition(position).toString();
                       if (!onclkfrom.equals(onclkto)){

                           if (onclkfrom.equals("Kalabagan")&&onclkto.equals("Gabtoli")){
                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("kalagab","kalagab");
                               startActivity(intent);
                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }else if (onclkfrom.equals("Kalabagan")&&onclkto.equals("Mirpur")){
                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("kalamir","kalamir");
                               startActivity(intent);
                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }else if (onclkfrom.equals("Kalabagan")&&onclkto.equals("Agargoan")){
                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("kalaagar","kalaagar");
                               startActivity(intent);
                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();
                           }else if (onclkfrom.equals("Kalabagan")&&onclkto.equals("Gulisthan")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("kalagul","kalagul");
                               startActivity(intent);

                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }else if (onclkfrom.equals("Kalabagan")&&onclkto.equals("Azimpur")){
                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("kalaazim","kalaazim");
                               startActivity(intent);
                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }

                           //selecting gabtoli root

                           else if (onclkfrom.equals("Gabtoli")&&onclkto.equals("Azimpur")){
                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("gabazim","gabazim");
                               startActivity(intent);

                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }else if (onclkfrom.equals("Gabtoli")&&onclkto.equals("Gulisthan")){
                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("gabgul","gabgul");
                               startActivity(intent);

                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }else if (onclkfrom.equals("Gabtoli")&&onclkto.equals("Airport")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("gabaair","gabaair");
                               startActivity(intent);

                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }else if (onclkfrom.equals("Gabtoli")&&onclkto.equals("Komolapur")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("gabakom","gabakom");
                               startActivity(intent);

                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }
                           //select root airpoart

                           else if (onclkfrom.equals("Airport")&&onclkto.equals("Badda")){
                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("airbadd","airbadd");
                               startActivity(intent);

                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           } else if (onclkfrom.equals("Airport")&&onclkto.equals("Azimpur")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("airazim","airazim");
                               startActivity(intent);

                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           } else if (onclkfrom.equals("Airport")&&onclkto.equals("Agargoan")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("airagor","airagor");
                               startActivity(intent);
                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }

                           //mirpur root
                           else if (onclkfrom.equals("Mirpur")&&onclkto.equals("Gulisthan")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("mirgul","mirgul");
                               startActivity(intent);

                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           } else if (onclkfrom.equals("Mirpur")&&onclkto.equals("Azimpur")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("mirazim","mirazim");
                               startActivity(intent);

                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();
                           }

                           else if (onclkfrom.equals("Agargoan")&&onclkto.equals("Gulisthan")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("agargul","agargul");
                               startActivity(intent);

                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }else if (onclkfrom.equals("Agargoan")&&onclkto.equals("Airpoart")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("airagor","airagor");
                               startActivity(intent);

                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }else if (onclkfrom.equals("Agargoan")&&onclkto.equals("Komolapur")){
                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("agarkom","agarkom");
                               startActivity(intent);

                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }



                           else if (onclkfrom.equals("Gulisthan")&&onclkto.equals("Agargoan")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("agargul","agargul");
                               startActivity(intent);

                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }else if (onclkfrom.equals("Gulisthan")&&onclkto.equals("Mirpur")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("mirgul","mirgul");
                               startActivity(intent);
                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();


                           }else if (onclkfrom.equals("Gulisthan")&&onclkto.equals("Gabtoli")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("gabgul","gabgul");
                               startActivity(intent);
                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }else if (onclkfrom.equals("Gulisthan")&&onclkto.equals("Kalabagan")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("kalagul","kalagul");
                               startActivity(intent);
                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();
                           }




                           else if (onclkfrom.equals("Azimpur")&&onclkto.equals("Mirpur")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("mirazim","mirazim");
                               startActivity(intent);
                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();



                           }else if (onclkfrom.equals("Azimpur")&&onclkto.equals("Airport")){
                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("airazim","airazim");
                               startActivity(intent);

                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }else if (onclkfrom.equals("Azimpur")&&onclkto.equals("Gabtoli")){
                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("gabazim","gabazim");
                               startActivity(intent);

                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }else if (onclkfrom.equals("Azimpur")&&onclkto.equals("Kalabagan")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("kalaazim","kalaazim");
                               startActivity(intent);

                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();
                           }


                           else if (onclkfrom.equals("Komolapur")&&onclkto.equals("Agargoan")){
                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("agarkom","agarkom");
                               startActivity(intent);
                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }else if (onclkfrom.equals("Komolapur")&&onclkto.equals("Gabtoli")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("gabakom","gabakom");
                               startActivity(intent);
                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }else if (onclkfrom.equals("Komolapur")&&onclkto.equals("Badda")){
                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("kombad","kombad");
                               startActivity(intent);
                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }


                           else if (onclkfrom.equals("Badda")&&onclkto.equals("Komolapur")){

                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("kombad","kombad");
                               startActivity(intent);
                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           } else if (onclkfrom.equals("Badda")&&onclkto.equals("Airport")){
                               Intent intent=new Intent(MainActivity.this,BusSelection.class);
                               intent.putExtra("airbadd","airbadd");
                               startActivity(intent);
                               Toast.makeText(MainActivity.this, onclkfrom+"  and "+onclkto, Toast.LENGTH_SHORT).show();

                           }


                           else {
                               Toast.makeText(MainActivity.this, "There is no bus in this root ", Toast.LENGTH_SHORT).show();
                           }



                       }else {
                           Toast.makeText(MainActivity.this, "your destination and depreture place is same ", Toast.LENGTH_SHORT).show();
                       }
                   }

                   @Override
                   public void onNothingSelected(AdapterView<?> parent) {

                   }
               });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
