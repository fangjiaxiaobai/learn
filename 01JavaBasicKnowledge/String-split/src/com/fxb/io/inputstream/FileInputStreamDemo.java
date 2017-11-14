package com.fxb.io.inputstream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @create by: wangxiyue on 2017/7/14 14:51.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class FileInputStreamDemo {

    private static final String rootPath="temp" + File.separator + "fxb";

    public static void main(String[] args){

        File file=new File(rootPath + "1.txt");
        try {
           FileInputStream fileInputStream = new FileInputStream(file);

           byte []buff = new byte[1024];
           int flag ;
            while (-1 != (flag=fileInputStream.read(buff))) {
                System.out.println(new String(buff,0,flag));
            }

           fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
