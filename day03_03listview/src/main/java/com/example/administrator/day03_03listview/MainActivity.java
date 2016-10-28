package com.example.administrator.day03_03listview;

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
  ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.listview);
        listView.setAdapter(new MyListAdaper());
    }
    private class MyListAdaper extends BaseAdapter
    {

    //一共有多少条数据需要展示
        @Override
        public int getCount()
        {
            return 100000;
        }
//返回指定position位置对应的对象
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
            if (view==null)
            {
                tv=new TextView(MainActivity.this);
                Log.e("自定义标签", "类名==MyListAdaper" + "方法名==getView=====:" + "");

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
