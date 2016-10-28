package com.example.administrator.day07_01imoocaidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/10/6.
 */

public class IRemoteService extends Service
{
    //当客户端绑定到该服务
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return iBinder;//只要绑定了服务就会得到iBinder对象,并实现了方法
    }

    private IBinder iBinder=new IImoocAIDL.Stub(){
        @Override
        public int add(int num1, int num2) throws RemoteException
        {
            Log.e("自定义标签", "类名==IRemoteService" + "方法名==add=====:" + "收到了远程请求");
            return num1+num2;
        }
    };
}
