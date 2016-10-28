package com.example.administrator.day06_04sms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MsmModelActivity extends AppCompatActivity
{

    String objects[]={"1","2","3","4"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msm_model);
        listView= (ListView) findViewById(R.id.listview_sms);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.msm_item,objects);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String sms = objects[position];
                //把数据返回给调用者
                Intent intent=new Intent();
                intent.putExtra("smscontent",sms);
                setResult(20,intent);


                //关闭Activity
                   finish();
            }
        });

    }
}
