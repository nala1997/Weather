package edu.niit.weatherforecast.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.niit.weatherforecast.entity.City;
import edu.niit.weatherforecast.utils.DBHelper;

// 功能：完成City表的记录的CRUD
public class CityDao {
    private DBHelper helper;
    // 构造方法，初始化DBHelper对象
    public CityDao(Context context){
        helper=new DBHelper(context,1);
    }
    // 1. 查询所有的记录，给CursorAdapter使用
    public Cursor getCursor(){
        // 1. 获取SQLiteDatabse对象db
        SQLiteDatabase db = helper.getReadableDatabase();
        // 2. 执行db.query()方法获取Cursor对象，
        // 相当于sql：select * from student
        Cursor cursor = db.query("city", null, null, null,
                null, null, null);
//        Cursor cursor = db.rawQuery("select * from student", null);
      return cursor;
    }

    public void insert(City city){
        // 1. 获取SQLiteDatabse对象db
        SQLiteDatabase db=helper.getWritableDatabase();
        // 2. 组装需要插入的数据ContentValues对象
        ContentValues values=new ContentValues();
        values.put("province",city.getProvince());
        values.put("city",city.getCity());
        values.put("number",city.getNumber());
        values.put("allPY",city.getAllPY());
        values.put("allfirstPY",city.getAllfirstPY());
        values.put("firstPY",city.getFirstPY());
        // 3. 执行db.update()方法更新记录
        long id=db.insert("city",null,values);
        // 4. 关闭数据库
        db.close();
    }

    public void update(City city){
        // 1. 获取SQLiteDatabse对象db
        SQLiteDatabase db=helper.getWritableDatabase();
        // 2. 组装需要插入的数据ContentValues对象
        ContentValues values=new ContentValues();
        values.put("province",city.getProvince());
        values.put("city",city.getCity());
        values.put("number",city.getNumber());
        values.put("allPY",city.getAllPY());
        values.put("allfirstPY",city.getAllfirstPY());
        values.put("firstPY",city.getFirstPY());
        long id=db.update("city",values,"_id=?",new String[] {String.valueOf(city.get_id())});
        db.close();
    }

    public void delete(int id){
        SQLiteDatabase db=helper.getWritableDatabase();
        db.delete("city","_id=?",new String[]{String.valueOf(id)});
        db.close();
    }

    //另一种方法：直接执行SQL语句，使用万能的execSQL()方法
    public void insertBySQL(City city){
        String sql="insert into city(province,city,number,allPY,allfirstPY,firstPY)values(?,?,?,?,?,?)";
        SQLiteDatabase db=helper.getWritableDatabase();
        db.execSQL(sql,new String[]{
                city.getProvince(),
                city.getCity(),
                city.getNumber(),
                city.getAllPY(),
                city.getAllfirstPY(),
                city.getFirstPY()});
        db.close();
    }

    public void updateBySQL(City city){
        String sql="update city set province=?,city=?,number=?,allPY=?,allfirstPY=?,firstPY=? where _id=?";
        SQLiteDatabase db=helper.getWritableDatabase();
        db.execSQL(sql,new String[]{
                city.getProvince(),
                city.getCity(),
                city.getAllPY(),
                city.getAllfirstPY(),
                city.getFirstPY()});
        db.close();
    }

    public  void deleteBySQL(int id){
        String sql="delete from city where _id=?";
        SQLiteDatabase db=helper.getWritableDatabase();
        db.execSQL(sql,new String[]{String.valueOf(id)});
        db.close();
    }

}
