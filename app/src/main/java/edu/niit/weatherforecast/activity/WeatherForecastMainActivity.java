package edu.niit.weatherforecast.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.niit.weatherforecast.R;
import edu.niit.weatherforecast.adapter.CityCursorApdater;
import edu.niit.weatherforecast.adapter.WeatherAdapter;
import edu.niit.weatherforecast.dao.CityDao;
import edu.niit.weatherforecast.entity.City;

public class WeatherForecastMainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView Title_City;

    private ViewPager pager_weather;
    private ArrayList<View> weatherList;
    private WeatherAdapter weatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast_main);
        Title_City=findViewById(R.id.title_city);
        Title_City.setOnClickListener(this);
        pager_weather=(ViewPager) findViewById(R.id.weekly_weather);

        weatherList=new ArrayList<View>();
        LayoutInflater inflater=getLayoutInflater();
        weatherList.add(inflater.inflate(R.layout.weekly_one,null,false));
        weatherList.add(inflater.inflate(R.layout.weekly_two,null,false));
        weatherAdapter=new WeatherAdapter(weatherList);
        pager_weather.setAdapter(weatherAdapter);
        pager_weather.setOffscreenPageLimit(10);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_city:
                Intent intent=new Intent(WeatherForecastMainActivity.this,SelectActivity.class);
                startActivity(intent);
                break;
        }
    }
    }

