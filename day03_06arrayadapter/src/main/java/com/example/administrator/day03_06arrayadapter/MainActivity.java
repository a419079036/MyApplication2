package com.example.administrator.day03_06arrayadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{

    String objects[] = {"小美", "小米", "小明"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = (ListView) findViewById(R.id.List4);
        //创建一个ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item, objects);
        lv.setAdapter(adapter);

    }


}
