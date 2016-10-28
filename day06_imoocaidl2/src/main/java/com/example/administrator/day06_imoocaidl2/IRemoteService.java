package com.example.administrator.day06_imoocaidl2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/10/5.
 */

public class IRemoteService extends Service
{
    /**
     * 当客户端绑定到该服务的时候会执行
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return iBinder;
    }
    private IBinder iBinder= new ImoocAIDL.Stub()
    {
        @Override
        public int add(int num1, int num2) throws RemoteException
        {
            Log.e("自定义标签", "类名==IRemoteService" + "方法名==add=====:" + "收到了远程请求");
            return num1+num2;
        }
    };
}
