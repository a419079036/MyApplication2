package com.example.administrator.day06_imooocaidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private EditText ed_num1;
    private EditText ed_num2;
    private TextView tv_result;
    private Button bt_add;
    private ServiceConnection conn=new ServiceConnection()
    {
        //绑定上服务的时候
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {

        }

        //当服务断开的时候
        @Override
        public void onServiceDisconnected(ComponentName name)
        {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_num1 = (EditText) findViewById(R.id.edit_num1);
        ed_num2 = (EditText) findViewById(R.id.edit_num2);
        tv_result = (TextView) findViewById(R.id.tv_result);

    }

    public void OnClick(View view)
    {
        //获取到服务端通过绑定服务
        Intent intent=new Intent();
        intent.setComponent(new ComponentName("com.example.administrator.day06_imoocaidl2","com.example.administrator.day06_imoocaidl2.IRemoteService"));
        //5.0之后必须显示Intent启动绑定服务
        bindService(intent,conn, Context.BIND_AUTO_CREATE);


    }
}
