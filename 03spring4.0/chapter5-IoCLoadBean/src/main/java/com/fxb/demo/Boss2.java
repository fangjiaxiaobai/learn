package com.fxb.demo;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author wangxiyue on 2017/9/23 14:30.
 * @description
 */
public class Boss2 implements MethodReplacer {
    public void test(){
        System.out.println("这是 boss2 中的方法。。。。。");
    }
    
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println( "进入了 替换方法 。。。" );
            test();
        return null;
    }
}
