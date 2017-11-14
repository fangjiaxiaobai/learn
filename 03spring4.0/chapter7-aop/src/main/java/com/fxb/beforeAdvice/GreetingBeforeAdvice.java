package com.fxb.beforeAdvice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author wangxiyue on 2017/9/26 20:57.
 * @description
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String name = (String) objects[0];
        System.out.println("在 目标方法执行前。。。。。。should say hello。");
        
    }
}
