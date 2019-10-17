package com.example.onekkosteachi.Interface_retrofit;

import com.example.onekkosteachi.All_ModelClass.Book;
import com.example.onekkosteachi.All_ModelClass.Results;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("current/hardcover-fiction.json?api-key=YWbdALlQNcVSaqXlgpkPwYYheK2zt3Fu")
    Call<List<Results>>allbooks();
}
