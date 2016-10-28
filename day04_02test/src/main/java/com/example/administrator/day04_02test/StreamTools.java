package com.example.administrator.day04_02test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/10/2.
 */

public class StreamTools
{
    public static byte[] isTodata(InputStream is) throws IOException
    {
        //字节输出流
        ByteArrayOutputStream bops=new ByteArrayOutputStream();
        //读取数据的缓冲区
        byte buffer[]=new byte[1024];
        //读取记录的长度
        int len=0;
        while((len=is.read(buffer))!=-1){
            bops.write(buffer, 0, len);
        }
        //把读取的内容转换成byte数组
        byte data[]=bops.toByteArray();
        return data;
    }

}
