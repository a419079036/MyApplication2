package com.example.administrator.day04_02test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/10/2.
 */

public class HttpUtils
{
    public static String sendGet(String path){
        String content=null;
        try{
            //设置访问的url
            URL url=new URL(path);
            //打开请求
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            //设置请求的信息
            httpURLConnection.setRequestMethod("GET");
            //设置请求是否超时
            httpURLConnection.setConnectTimeout(5000);
            //判断服务器是否响应成功
            if(httpURLConnection.getResponseCode()==200){
                //获取响应的输入流对象
                InputStream is=httpURLConnection.getInputStream();
                byte data[]=StreamTools.isTodata(is);
                //把转换成字符串
                content=new String(data);
                //内容编码方式
                if(content.contains("gb2312")){
                    content=new String(data,"gb2312");
                }
            }
            //断开连接
            httpURLConnection.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }

        return content;
    }


    public static Bitmap sendGets(String path){
        Bitmap bitmap=null;
        try{
            //设置访问的url
            URL url=new URL(path);
            //打开请求
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            //设置请求的信息
            httpURLConnection.setRequestMethod("GET");
            //设置请求是否超时
            httpURLConnection.setConnectTimeout(5000);
            //判断服务器是否响应成功
            if(httpURLConnection.getResponseCode()==200){
                //获取响应的输入流对象
                InputStream is=httpURLConnection.getInputStream();
                //直接把is的流转换成Bitmap对象
                bitmap= BitmapFactory.decodeStream(is);
            }
            //断开连接
            httpURLConnection.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }

        return bitmap;
    }
}
