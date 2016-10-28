package com.example.administrator.day04_03cache;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.bt1:
                try
                {
                    File file=new File(getCacheDir(),"info.text");
                    FileOutputStream fos=new FileOutputStream(file);
                    fos.write("呵呵".getBytes());
                    fos.close();
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }


                break;
            case R.id.bt2:
                try
                {

                    FileOutputStream fos = openFileOutput("info.txt", 0);
                    fos.write("haha".getBytes());
                    fos.close();
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                break;
        }


    }
}
