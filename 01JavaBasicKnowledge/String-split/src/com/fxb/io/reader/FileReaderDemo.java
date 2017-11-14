package com.fxb.io.reader;

import java.io.File;
import java.io.FileReader;

/**
 * @create by: wangxiyue on 2017/7/14 13:51.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class FileReaderDemo {
    private static final String rootPath="temp" + File.separator + "fxb";

    public static void main(String[] args){

        File file=new File(rootPath + "1.txt");
        try {
            FileReader fileReader=new FileReader(file);
            char[] buff=new char[1024];

            int flag=0;
            while (-1 != (flag=fileReader.read(buff))) {
                System.out.println(new String(buff,0,flag));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

