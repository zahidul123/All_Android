package com.example.aunshon.weather.webapi;

import com.example.aunshon.weather.Forcast.WeatherForcast;
import com.example.aunshon.weather.models.Weathercls;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherApi {
    @GET("api/76be701302e76aeb/conditions/q/BD/Dhaka.json")
    Call<Weathercls>getWeatherDhaka();

    @GET("api/76be701302e76aeb/conditions/q/BD/Chittagong.json")
    Call<Weathercls>getWeatherChittagong();

    @GET("api/76be701302e76aeb/conditions/q/BD/Jessore.json")
    //@GET("api/76be701302e76aeb/conditions/q/CA/San_Francisco.json")
    Call<Weathercls>getWeatherJessore();

    @GET("api/76be701302e76aeb/forecast10day/q/BD/Dhaka.json")
    Call <WeatherForcast> getWeatherforcastDhaka();
}
