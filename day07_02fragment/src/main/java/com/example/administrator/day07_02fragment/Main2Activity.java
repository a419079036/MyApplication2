package com.example.administrator.day07_02fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity
{

    private ContentFragment contentFragment;
    private TitleFragment titleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addcontentLayout();
    }

    //通过代码添加Fragment
    private void addcontentLayout()
    {

        android.app.FragmentManager fm=getFragmentManager();
        //开启一个事物
        FragmentTransaction ft = fm.beginTransaction();
        contentFragment=new ContentFragment();
        titleFragment= new TitleFragment();
        ft.add(R.id.content_fragment2,contentFragment);//添加Fragment
        ft.add(R.id.title_fragment2,titleFragment);
        ft.commit();//一定要提交事物


    }


}
