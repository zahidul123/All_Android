package com.example.aunshon.weather.webapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitclient {
    public static Retrofit getretrofitclient(){
        return  new Retrofit.Builder()
                .baseUrl("http://api.wunderground.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
