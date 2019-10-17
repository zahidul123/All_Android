package com.example.onekkosteachi;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.onekkosteachi.All_ModelClass.Book;
import com.example.onekkosteachi.All_ModelClass.Booklist;
import com.example.onekkosteachi.All_ModelClass.Results;
import com.example.onekkosteachi.Interface_retrofit.ApiInterface;
import com.example.onekkosteachi.Interface_retrofit.ServerMethod;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar mToolbar;
    Bookadapter bookadapter;
    List<Results>arrbooklists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mToolbar = findViewById(R.id.tolbar);
        arrbooklists=new ArrayList<>();
        bookadapter=new Bookadapter(MainActivity.this,arrbooklists);
        ApiInterface apiInterface= ServerMethod.getretrofitdata().create(ApiInterface.class);
        Call<List<Results>> responsed=apiInterface.allbooks();
        responsed.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                int array=response.body().size();
                   Log.e("response "," "+response.body());
                    arrbooklists=response.body();
                Toast.makeText(MainActivity.this," "+arrbooklists,Toast.LENGTH_LONG).show();
                recyclerView.setAdapter(bookadapter);
            }

            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {
                Log.e("on failure  "," "+t);

                Toast.makeText(MainActivity.this," "+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
