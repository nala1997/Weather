package edu.niit.weatherforecast.activity;

import android.app.Application;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.niit.weatherforecast.R;
import edu.niit.weatherforecast.adapter.CityCursorApdater;
import edu.niit.weatherforecast.dao.CityDao;
import edu.niit.weatherforecast.entity.City;

public class SelectActivity extends AppCompatActivity implements View.OnClickListener{
    private ListView cityList;
    private CityDao cityDao;
    private City city;
    private CityCursorApdater apdater;
    private ImageView Btn_Back;

    private List<City> mCityList;
    private Application myApplication;
    private ArrayList<String> mArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_city);
        cityList=findViewById(R.id.city_item);
        cityDao=new CityDao(this);

        Btn_Back=findViewById(R.id.btn_back);
        Btn_Back.setOnClickListener(this);

        String[] listData={"北京-北京","北京-顺义","北京-海淀","上海-上海","上海-保定","上海-嘉定","上海-金山","天津-天津","天津-大港","天津-蓟县","重庆-重庆","重庆-合川","重庆-江津"};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(SelectActivity.this,
                android.R.layout.simple_list_item_1,listData);
        cityList.setAdapter(arrayAdapter);


        /*Cursor cursor=cityDao.getCursor();
        if (cursor!=null){
            apdater=new CityCursorApdater(this,cursor);
            cityList.setAdapter(apdater);
        }
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Cursor cursor= (Cursor) adapterView.getItemAtPosition(position);
                if (cursor!=null){
                    city=new City(
                            cursor.getInt(cursor.getColumnIndex("_id")),
                            cursor.getString(cursor.getColumnIndex("province")),
                            cursor.getString(cursor.getColumnIndex("city")),
                            cursor.getString(cursor.getColumnIndex("number")),
                            cursor.getString(cursor.getColumnIndex("allPY")),
                            cursor.getString(cursor.getColumnIndex("allfirstPY")),
                            cursor.getString(cursor.getColumnIndex("firstPY")));
                }
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                finish();
                break;
        }

    }
}
