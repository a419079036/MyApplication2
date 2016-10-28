package com.example.administrator.day04_01urlconnection;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static java.net.HttpURLConnection.HTTP_OK;

public class MainActivity extends AppCompatActivity
{
    private static  final  int REQUESTSUCESS=0;
    private static  final  int REQUEFAIL=1;

    private EditText editText;
    private TextView textView;

    private Handler hander=new Handler()
    {
        //这个方法是在主线程里面执行,使用就能更新UI
        @Override
        public void handleMessage(Message msg)
        {

            switch (msg.what)
            {
                case  REQUESTSUCESS:
                    String content = (String) msg.obj;
                    textView.setText(content);
                break;
                case  REQUEFAIL:
                    Toast.makeText(getApplicationContext(),"请求资源不存在",Toast.LENGTH_LONG).show();
                    break;


            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit);
        textView = (TextView) findViewById(R.id.text);
    }

    //点击按钮查询网页源码
    public void OnClick(View view)
    {

        new Thread(){

            @Override
            public void run()
            {
                try
                {
                    // String path = editText.getText().toString().trim();
                    String path ="https://www.baidu.com";
                    URL url=new URL(path);//创建URL对象,指定访问对象
                    //拿到httpurlconnection
                    HttpURLConnection conn= (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(5000);
                    conn.setRequestMethod("GET");//设置请求方法,默认就是GET请求
                    //获取服务器返回的状态码
                    int code = conn.getResponseCode();
                    if (code==HTTP_OK)
                    {

                        InputStream in=conn.getInputStream();
                        //把流里面的数据展示到textview
                        String content = StreamTools.readSream(in);
                        //用hander
                        Message msg=new Message();
                        msg.obj=content;
                        hander.sendMessage(msg);//发了一条消息,把数据放到msg里面,然后handerMessage就会执行
                        Log.e("自定义标签", "类名==MainActivity" + "方法名==run=====:" + content);

                    }
                    else
                    {
                        //toast也是一个view,所以不能直接更新,
                        Message msg=new Message();

                        msg.what= REQUEFAIL;
                        hander.sendMessage(msg);
                        Toast.makeText(getApplicationContext(),"资源不存在",Toast.LENGTH_LONG).show();

                    }

                }
                catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }


            }
        }.start();


    }
}
