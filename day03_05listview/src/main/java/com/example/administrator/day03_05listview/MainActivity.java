package com.example.administrator.day03_05listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview3);
        listView.setAdapter(new MyAdapter());

    }

    private class MyAdapter extends BaseAdapter
    {
        @Override
        public int getCount()
        {
            return 7;
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
            View itemView;
            if (view == null)
            {
                itemView = View.inflate(getApplicationContext(), R.layout.item, null);
            } else
            {

                itemView = view;
            }
            return itemView;
        }
    }
}
