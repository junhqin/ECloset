package com.ecloset.Bean;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

//import com.example.findlist.bean.TODO;

public class MySqliteDB extends SQLiteOpenHelper {
    private static final String DB_NAME = "ecloset.db";
    private static  Context cont;
    //这里把数据库写死了
    public MySqliteDB(Context context){
        super(context,DB_NAME,null,1);
        cont = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table clothes("+
                        "id integer primary key autoincrement,"+
                        "name text,"+
                        "category text,"+
                        "imgPath text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

//    public void insert(TODO todo){
//        SQLiteDatabase db = getWritableDatabase();
//        //存取数据键值对
//        ContentValues values = new ContentValues();
//        values.put("content", todo.getContent());
//        values.put("date", todo.getDate());
//
//        db.insert("todos", null, values);
//        Toast.makeText(cont,"代办事项创建成功",Toast.LENGTH_SHORT).show();
//    }

    public void addClothes(String name,String category, String imgPath){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("imgPath",imgPath);
        values.put("category",category);
        db.insert("clothes",null,values);
    }


//    public void delete(String taskId){
//        SQLiteDatabase db = getWritableDatabase();
//        db.delete("todos", "id = ?", new String[]{taskId});
//        Toast.makeText(cont, "该任务已完成",Toast.LENGTH_SHORT).show();
//    }

}
