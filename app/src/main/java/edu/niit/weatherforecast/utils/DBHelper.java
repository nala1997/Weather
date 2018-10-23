package edu.niit.weatherforecast.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    // SQLite创建数据库及表的辅助类
    public DBHelper(Context context, int version) {
        super(context, "city.db", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 1. 定义个字符串 - 创建表(_id 整型 主键 自增）
        String sql="create table city(" +
                "_id integer primary key autoincrement," +
                "province varchar(20)," +
                "city varchar(20)," +
                "number varchar(20)," +
                "allPY varchar(20)," +
                "allfirstPY varchar(20)," +
                "firstPY varchar(20))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     //删除city表
        String sql="drop table if exists city";
        onCreate(db);
    }
}
