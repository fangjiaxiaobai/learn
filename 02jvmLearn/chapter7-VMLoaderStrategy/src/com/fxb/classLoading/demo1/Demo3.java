package com.fxb.classLoading.demo1;

/**
 * @author fangxiaobai on 2017/10/16 17:25.
 * @description
 */
public class Demo3 {
    
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}


class ConstClass{
    static {
        System.out.println("ConstClass init!");
    }
    
    public static final String HELLOWORLD = "hello world" ;
    
}
