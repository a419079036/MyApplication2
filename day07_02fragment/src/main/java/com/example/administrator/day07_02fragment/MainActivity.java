package com.example.administrator.day07_02fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

    private TitleFragment titleFragment;
    private ContentFragment contentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleFragment = (TitleFragment) getFragmentManager().findFragmentById(R.id.title_fragment);
        contentFragment = (ContentFragment) getFragmentManager().findFragmentById(R.id.content_fragment);
        //通过Fragment管理器,获取到Fragment实例
        

    }
}
