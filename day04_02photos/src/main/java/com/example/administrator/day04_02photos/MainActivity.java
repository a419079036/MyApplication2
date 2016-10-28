package com.example.administrator.day04_02photos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static java.net.HttpURLConnection.HTTP_OK;

public class MainActivity extends AppCompatActivity
{
    private ImageView imageView;
    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            Bitmap bitmap = (Bitmap) msg.obj;
            imageView.setImageBitmap(bitmap);


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.img);

    }

    public void OnClick(View view)
    {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==OnClick=====:" + "");
        new Thread()
        {
            @Override
            public void run()
            {

                try
                {
                    String path = "https://passport.sanjieke.cn/Public/v3.4/img/code-icon.png";
                    URL url = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(5000);
                    conn.setConnectTimeout(5000);
                    conn.setRequestMethod("GET");
                    int code = conn.getResponseCode();

                    if (code == HTTP_OK)
                    {
                        InputStream in = conn.getInputStream();
                        File file=new File(getCacheDir(),"test.png");//缓存目录
                        FileOutputStream fos=new FileOutputStream(file);
                        int len=-1;
                        byte[] buffer=new byte[1024];
                         len = in.read(buffer);
                        while (len!=-1)
                        {
                            fos.write(buffer,0,len);

                        }
                        fos.close();
                        in.close();
                        conn.disconnect();

                        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                        Message msg = Message.obtain();
                        msg.obj = bitmap;
                        handler.sendMessage(msg);


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
