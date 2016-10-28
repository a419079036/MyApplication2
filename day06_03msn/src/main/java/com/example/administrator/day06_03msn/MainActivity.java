package com.example.administrator.day06_03msn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{

    private ListView listView;
    String ojects[] = {"123", "234", "345"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item, ojects);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    //当listview被点击的时候被调用

                    /**
                     *
                     * @param parent:父组件
                     * @param view
                     * @param position:位置从0开始
                     * @param id
                     */
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        //把点击条目的数据取出来,原则数据在那里面存着就去那里取
                        String msn = ojects[position];
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.SEND");//源码查找
                        intent.addCategory("android.intent.category.DEFAULT");
                        intent.setType("text/plain");

                        intent.putExtra("sms_body",msn);
                        //跳转到发送短信界面
                        startActivity(intent);

                    }
                }
        );

    }


}
