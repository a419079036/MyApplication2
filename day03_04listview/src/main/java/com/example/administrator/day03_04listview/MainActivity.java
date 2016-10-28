package com.example.administrator.day03_04listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       ListView lv= (ListView) findViewById(R.id.list);
        lv.setAdapter(new MyAdapter());
    }
    private class MyAdapter extends BaseAdapter{
        @Override
        public int getCount()
        {
            return 6;
        }

        @Override
        public Object getItem(int i)
        {
            return null;
        }

        @Override
        public long getItemId(int i)
        {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            TextView tv;
            Log.e("自定义标签", "类名==MyAdapter" + "方法名==getView=====:" + i);
            if (view==null)
            {
                tv=new TextView(MainActivity.this);


            }
            else
            {
                tv= (TextView) view;

            }
            tv.setText("hhh"+i);
            return tv;
        }
    }
}


