package com.example.administrator.day06_01activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.bt1:
                //创建一个意图对象
                Log.e("自定义标签", "类名==MainActivity" + "方法名==OnClick=====:" + "");
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+119));
                startActivity(intent);
               
                break;
            case R.id.bt2:
                Intent intent2=new Intent();

                intent2.setAction("com.day05.testactivity");
               // intent2.addCategory("android.intent.category.DEFAULT");
                startActivity(intent2);
                break;
            case R.id.bt3:
                Log.e("自定义标签", "类名==MainActivity" + "方法名==OnClick=====:" + "");
                Intent intent3=new Intent(this,TestActivity.class);
                startActivity(intent3);
                break;
        }

    }
}
