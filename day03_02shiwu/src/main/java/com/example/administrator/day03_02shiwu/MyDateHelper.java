package com.example.administrator.day03_02shiwu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2016/9/28.
 */
public class MyDateHelper extends SQLiteOpenHelper
{
    public MyDateHelper(Context context)
    {
        super(context, "Account.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("create table info (_id integer primary key autoincrement,name varchar(20),phone varchar(20),money varchar(20))");
        sqLiteDatabase.execSQL("insert into info('name','phone','money') values('张三','123456','2000')");
        sqLiteDatabase.execSQL("insert into info('name','phone','money') values('李四','133333','5000')");
        Log.e("自定义标签", "类名==MyDateHelper" + "方法名==onCreate=====:" + "");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
}
