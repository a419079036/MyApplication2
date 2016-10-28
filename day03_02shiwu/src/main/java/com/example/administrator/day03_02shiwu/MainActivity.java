package com.example.administrator.day03_02shiwu;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    MyDateHelper myDateHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDateHelper=new MyDateHelper(this);
    }
    public void OnClick(View view)
    {
        SQLiteDatabase db = myDateHelper.getWritableDatabase();
        db.beginTransaction();

        try
        {
            db.execSQL("update info set money=money-100 where name=?",new  Object[]{"张三"});
            db.execSQL("update info set money=money+100 where name=?",new  Object[]{"李四"});
            db.setTransactionSuccessful();

        }
        catch (Exception e)
        {


        }
        finally
        {
          db.endTransaction();
        }

    }
}
