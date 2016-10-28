package com.example.administrator.day03_07simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv= (ListView) findViewById(R.id.lv);
        List<Map<String,String>> data=new ArrayList<Map<String,String>>();
        Map<String,String> map1=new HashMap<String,String>();
        map1.put("name","张飞");
        map1.put("phone","1233333");

        Map<String,String> map2=new HashMap<String,String>();
        map2.put("name","赵云");
        map2.put("phone","1333333");

        Map<String,String> map3=new HashMap<String,String>();
        map3.put("name","吕布");
        map3.put("phone","12222");

        //把Map加到集合中
        data.add(map1);
        data.add(map2);
        data.add(map3);


        SimpleAdapter adapter=new SimpleAdapter(this,data,R.layout.item,new String[]{"name","phone"},new int[]{R.id.name,R.id.phone});
        lv.setAdapter(adapter);
    }
}
