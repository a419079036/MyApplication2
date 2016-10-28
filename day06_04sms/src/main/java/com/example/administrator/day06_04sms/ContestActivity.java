package com.example.administrator.day06_04sms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ContestActivity extends AppCompatActivity
{

    ListView listView;
    private String phone=null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest);
        listView= (ListView) findViewById(R.id.lv);
        //准备listview要显示的数据
        final List<Person> lists=new ArrayList<Person>();
        for (int i=0;i<20;i++)
        {
            Person person=new Person();
            person.setName("张"+i+"山");
            person.setPhone("11"+i);
            lists.add(person);
        }
            listView.setAdapter(new MyAdapter(lists));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                phone = lists.get(position).getPhone();
                Intent intent=new Intent();
                intent.putExtra("phone", phone);
                setResult(10,intent);//
                //关闭当前页面
                finish();

            }
        });

    }

}
