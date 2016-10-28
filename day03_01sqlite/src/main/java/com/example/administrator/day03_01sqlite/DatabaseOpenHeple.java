package com.example.administrator.day03_01sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2016/9/27.
 */
public class DatabaseOpenHeple extends SQLiteOpenHelper
{
    public DatabaseOpenHeple(Context context)
    {
        super(context, "ithema.db", null, 3);
    }

    /**
     * 当数据库第一次创建的时候执行
     * 用于表的初始化,用sql语句创建表
     * @param sqLiteDatabase:数据库对象
     *     用于管理数据库(增删改查)
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
      sqLiteDatabase.execSQL("create table info(_id integer primary key autoincrement,name varchar(20))");
    }

    /**
     * 数据库升级的时候调用
     * 用于表结构更新
     * @param sqLiteDatabase
     * @param i  老版本号
     * @param i1  新版本号
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        Log.e("自定义标签", "类名==DatabaseOpenHeple" + "方法名==onUpgrade=====:" + "");
      //  sqLiteDatabase.execSQL("alter table info add phone varchar(20)");

    }

}
