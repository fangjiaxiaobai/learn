package com.fxb.io.reader;

import java.io.*;

/**
 * @create by: wangxiyue on 2017/7/14 14:28.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class InputStreamReaderDemo {
    private static final String rootPath="temp" + File.separator + "fxb";

    public static void main(String[] args){

        File file=new File(rootPath + "1.txt");
        try {
            InputStreamReader fileReader=new InputStreamReader(new FileInputStream(file));
            char[] buff=new char[1024];

            int flag=0;
            while (-1 != (flag=fileReader.read(buff))) {
                System.out.println(new String(buff,0,flag));
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
