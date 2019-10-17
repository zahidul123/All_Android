package com.example.onekkosteachi.Interface_retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerMethod {
    private static final String base_url="https://api.nytimes.com/svc/books/v3/lists/";
    private static Retrofit retrofit=null;
    private static Gson gson=new GsonBuilder().setLenient().create();

    public static Retrofit getretrofitdata(){
        if (retrofit==null){
            synchronized (ServerMethod.class){
                if (retrofit==null){
                    retrofit=new Retrofit.Builder()
                            .baseUrl(base_url)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build();
                }
            }

        }
        return retrofit;
    }
}
