package com.example.administrator.day06_02renping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity
{
    private TextView tv_name;
    private TextView tv_sex;
    private TextView tv_renpin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv_name= (TextView) findViewById(R.id.tv1);
        tv_sex= (TextView) findViewById(R.id.tv2);
        tv_renpin= (TextView) findViewById(R.id.tv3);

        //获取intent传递过来的值
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int sex = intent.getIntExtra("sex",0);

        tv_name.setText("姓名:"+name);


        switch (sex)
        {
            case 1:
                tv_sex.setText("性别:"+"男");
                break;
            case 2:
                tv_sex.setText("性别:"+"女");
                break;
            case 3:
                tv_sex.setText("性别:"+"人妖");
                break;
        }
//        Intent intent = getIntent();
//        Uri data = intent.getData();



    }
}
