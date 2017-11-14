package com.fxb.io.reader;

import java.io.*;

/**
 * @create by: wangxiyue on 2017/7/14 14:42.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class BufferedReaderDemo {

    private static final String rootPath="temp" + File.separator + "fxb";

    public static void main(String[] args){

        File file=new File(rootPath + "1.txt");
        try {
            BufferedReader fileReader=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String flag ;
            while (null!=(flag=fileReader.readLine())) {
                System.out.println(flag);
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
