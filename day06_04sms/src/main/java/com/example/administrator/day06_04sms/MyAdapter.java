package com.example.administrator.day06_04sms;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/4.
 */

public class MyAdapter extends BaseAdapter
{
    List<Person> lists = new ArrayList<Person>();

    public MyAdapter(List<Person> lists)
    {
        this.lists=lists;
    }

    @Override
    public int getCount()
    {
        return lists.size();
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view;
        if (convertView == null)
        {
            view = View.inflate(parent.getContext(), R.layout.item, null);
        }
        else
        {
            view = convertView;
        }
       //找到在item中定义的控件,用来显示数据
        TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
        TextView tv_phone = (TextView) view.findViewById(R.id.tv_phone);
        tv_name.setText(lists.get(position).getName());
        tv_phone.setText(lists.get(position).getPhone());


        return view;
    }
}
