package com.fxb.crossMyMind;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * @create by: wangxiyue on 2017/7/14 16:46.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class FinalBlockTest {

    public static void main(String[] args){
        System.out.println(method());
    }


    public static String method(){
        try{
            return "method -try -block";
        }catch(Exception e){

        }finally{
            System.out.println("finally block");
            return "method - finally - block";
        }
    }
}
