package com.example.aunshon.weather;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aunshon.weather.Forcast.WeatherForcast;
import com.example.aunshon.weather.models.CurrentObservation;
import com.example.aunshon.weather.models.Weathercls;
import com.example.aunshon.weather.webapi.WeatherApi;
import com.example.aunshon.weather.webapi.retrofitclient;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    WeatherApi weatherApi2;
    WeatherApi weatherApiDhaka;
    Weathercls weathercls;
    WeatherApi weatherApiChittagong;
    WeatherApi weatherApiJessore;
    WeatherForcast weatherForcast;
    String arrayList;

    ImageView imageView;
    String url;
    TextView textView;
    Button button;
    ListView listView;
    Spinner spinner;
    TextView cityName;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.weather);
        imageView=findViewById(R.id.image);
        listView=findViewById(R.id.listview);
        spinner=findViewById(R.id.spinner);
        cityName=findViewById(R.id.cityEt);

        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(MainActivity.this,R.array.City,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //// forcast//////////////////////////////////////////////////////////////////////////////////////////
        weatherApi2= retrofitclient.getretrofitclient().create(WeatherApi.class);
        Call <WeatherForcast> WeatherForcastDhaka=weatherApi2.getWeatherforcastDhaka();
        WeatherForcastDhaka.enqueue(new Callback <WeatherForcast>() {

            @Override
            public void onResponse(Call <WeatherForcast> call, Response <WeatherForcast> response) {
                weatherForcast=response.body();
                //Toast.makeText(MainActivity.this, ""+weatherForcast.getForecast().getTxtForecast(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call <WeatherForcast> call, Throwable t) {

            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////////
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView <?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ""+parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

                    if(spinner.getSelectedItem().toString().equals("Dhaka")){
                        weatherApiDhaka= retrofitclient.getretrofitclient().create(WeatherApi.class);
                        Call<Weathercls>weatherCallDhaka=weatherApiDhaka.getWeatherDhaka();
                        weatherCallDhaka.enqueue(new Callback <Weathercls>() {
                            @Override
                            public void onResponse(Call <Weathercls> call, Response <Weathercls> response) {
                                weathercls= response.body();
                                url=weathercls.getCurrentObservation().getIconUrl().toString();

                                textView.setText(weathercls.getCurrentObservation().getTempC().toString());
                                cityName.setText(spinner.getSelectedItem().toString());
                                Picasso.with(MainActivity.this).load(url).placeholder(null)
                                        .into(imageView, new com.squareup.picasso.Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError() {
                                        Toast.makeText(MainActivity.this, "Image Failed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            @Override
                            public void onFailure(Call <Weathercls> call, Throwable t) {

                            }
                        });
                    }
                    else if(spinner.getSelectedItem().toString().equals("Chittagong")){
                        weatherApiChittagong= retrofitclient.getretrofitclient().create(WeatherApi.class);
                        Call<Weathercls>weatherCallChitagong=weatherApiChittagong.getWeatherChittagong();
                        weatherCallChitagong.enqueue(new Callback <Weathercls>() {
                            @Override
                            public void onResponse(Call <Weathercls> call, Response <Weathercls> response) {
                                weathercls= response.body();
                                url=weathercls.getCurrentObservation().getIconUrl().toString();
                                textView.setText(weathercls.getCurrentObservation().getTempC().toString());
                                cityName.setText(spinner.getSelectedItem().toString());
                                Picasso.with(MainActivity.this).load(url).placeholder(null).into(imageView, new com.squareup.picasso.Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError() {
                                        Toast.makeText(MainActivity.this, "Image Failed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            @Override
                            public void onFailure(Call <Weathercls> call, Throwable t) {

                            }
                        });

                    }

                    else if(spinner.getSelectedItem().toString().equals("Jessore")){
                        weatherApiJessore= retrofitclient.getretrofitclient().create(WeatherApi.class);
                        Call<Weathercls>weatherCallJessore=weatherApiJessore.getWeatherJessore();
                        weatherCallJessore.enqueue(new Callback <Weathercls>() {
                            @Override
                            public void onResponse(Call <Weathercls> call, Response <Weathercls> response) {
                                weathercls= response.body();
                                url=weathercls.getCurrentObservation().getIconUrl().toString();
                                //Toast.makeText(MainActivity.this, ""+weathercls.getCurrentObservation().getTemperatureString().toString(), Toast.LENGTH_SHORT).show();
                                //e.setText(weathercls.getCurrentObservation().getDisplayLocation().getCity().toString());
                                textView.setText(weathercls.getCurrentObservation().getTempC().toString());

                                cityName.setText(spinner.getSelectedItem().toString());
                                Picasso.with(MainActivity.this).load(url).placeholder(null).into(imageView, new com.squareup.picasso.Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError() {
                                        Toast.makeText(MainActivity.this, "Image Failed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            @Override
                            public void onFailure(Call <Weathercls> call, Throwable t) {

                            }
                        });
                    }
            }

            @Override
            public void onNothingSelected(AdapterView <?> parent) {
                Toast.makeText(MainActivity.this, "Select a City !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void lil(){
        weatherApi2= retrofitclient.getretrofitclient().create(WeatherApi.class);
        Call <WeatherForcast> WeatherForcastDhaka=weatherApi2.getWeatherforcastDhaka();
        WeatherForcastDhaka.enqueue(new Callback <WeatherForcast>() {

            @Override
            public void onResponse(Call <WeatherForcast> call, Response <WeatherForcast> response) {
                weatherForcast=response.body();
                arrayList= new String();
                arrayList=weatherForcast.getForecast().getTxtForecast().getForecastday().toString();
            }

            @Override
            public void onFailure(Call <WeatherForcast> call, Throwable t) {

            }
        });
    }



}
