package com.example.administrator.day04_01urlconnection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/9/28.
 */

public class StreamTools
{

    private static String content;

    public static String readSream(InputStream in)
    {
        ByteArrayOutputStream baos=new ByteArrayOutputStream();

        int len=-1;
        byte[] buffer=new byte[1024];
        try
        {
            while (( len=in.read(buffer))!=-1)
            {
                baos.write(buffer,0,len);

            }
            content = new String(baos.toByteArray());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
       return content;
    }
}
