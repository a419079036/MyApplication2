package com.example.administrator.day03_01sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    private DatabaseOpenHeple databaseOpenHeple;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseOpenHeple = new DatabaseOpenHeple(this);
       // SQLiteDatabase db = databaseOpenHeple.getWritableDatabase();
    }

    public void OnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.bt1:
                SQLiteDatabase db = databaseOpenHeple.getWritableDatabase();
               //增加
                db.execSQL("insert into info(name) values(?)",new Object[]{"张三"});

                db.close();//推荐:数据库用完需要关闭
                break;
            case R.id.bt2:
                SQLiteDatabase db2 = databaseOpenHeple.getWritableDatabase();
                //删除
                db2.execSQL("delete from info where name=?",new Object[]{"张三"});
                db2.close();//推荐:数据库用完需要关闭
                break;
            case R.id.bt3:
                SQLiteDatabase db3 = databaseOpenHeple.getWritableDatabase();
                //修改
                db3.execSQL("update info set phone=?  where name=?",new Object[]{"1399999","张三"});
             //   db3.update()
                db3.close();//推荐:数据库用完需要关闭
                break;
            case R.id.bt4:
                SQLiteDatabase db4 = databaseOpenHeple.getWritableDatabase();
                //修改
               // db4.execSQL("update info set phone=?  where name=?",new Object[]{"1399999","张三"});
                Cursor cursor = db4.rawQuery("select name,phone from info", null);
                if (cursor!=null &&cursor.getCount()>0)
                {
                    while (cursor.moveToNext())
                    {

                        String name=cursor.getString(1);
                     //   String phone = cursor.getString(2);
                        Log.e("自定义标签", "类名==MainActivity" + "方法名==OnClick=====:" + name);

                    }

                }

                db4.close();//推荐:数据库用完需要关闭
                break;
        }

    }
}
