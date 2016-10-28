package com.example.administrator.day07_imoocaidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import day07_01imoocaidl.IImoocAIDL;

public class MainActivity extends AppCompatActivity
{

    private EditText ed_num1;
    private EditText ed_num2;
    private TextView tv_result;
    private Button bt_add;
    IImoocAIDL iimoocAIDL;
    private ServiceConnection conn = new ServiceConnection()
    {
        //当我们绑定上服务的时候

        /**
         *
         * @param name
         * @param service:服务端返回的IBinder对象,
         *               就是实现的add()方法的服务
         */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            //  IImoocAIDL
            iimoocAIDL = IImoocAIDL.Stub.asInterface(service);


        }

        //当服务断开的时候
        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            iimoocAIDL = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_num1 = (EditText) findViewById(R.id.ed_num1);
        ed_num2 = (EditText) findViewById(R.id.ed_num2);
        tv_result = (TextView) findViewById(R.id.tv_result);
        bindService();//软件启动就绑定服务


    }

    public void OnClick(View view)
    {
        int result = 0;
        try
        {

            int num1 = Integer.parseInt(ed_num1.getText().toString().trim());
            int num2 = Integer.parseInt(ed_num2.getText().toString().trim());
            result = iimoocAIDL.add(num1, num2);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        tv_result.setText("结果是:" + result);

    }

    private void bindService()
    {
        //获取到服务端
        Intent intent = new Intent();
        //5.0之后必须显示绑定服务
        intent.setComponent(new ComponentName("com.example.administrator.day07_01imoocaidl",
                "com.example.administrator.day07_01imoocaidl.IRemoteService"));
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy()
    {
        unbindService(conn);
    }
}
