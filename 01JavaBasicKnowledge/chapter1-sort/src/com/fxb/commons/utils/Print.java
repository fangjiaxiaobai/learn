package com.fxb.commons.utils;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/1
 */
public class Print {

    public static void print(int []arr){
        for (int i : arr) {
            System.out.print(i+"  ");
        }
    }
    
    public static void println(int []arr){
        for (int i : arr) {
            System.out.print(i+"  ");
        }
        System.out.println();
    }

}
