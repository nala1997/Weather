package edu.niit.weatherforecast.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import edu.niit.weatherforecast.R;

public class CityCursorApdater extends CursorAdapter {

    public CityCursorApdater(Context context, Cursor c) {
        super(context, c,0);
    }

    // 加载ListView的每个子项select_city.xml
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.city_item,viewGroup,false);
    }
    // 绑定cursor
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView province=view.findViewById(R.id.tv_province);
        TextView city=view.findViewById(R.id.tv_city);
        province.setText(cursor.getString(cursor.getColumnIndex("province")));
        city.setText(cursor.getString(cursor.getColumnIndex("city")));

    }
}
