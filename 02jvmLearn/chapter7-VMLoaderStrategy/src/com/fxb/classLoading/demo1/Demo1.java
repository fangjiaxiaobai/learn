package com.fxb.classLoading.demo1;

/**
 * @author fangxiaobai on 2017/10/16 17:06.
 * @description
 */
public class Demo1 {
    
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}


class SuperClass{
    static{
        System.out.println("SuperClass init!");
    }
    
    public static int value = 123;
}


class SubClass extends SuperClass{
    static{
        System.out.println("SubClass init!");
    }
}