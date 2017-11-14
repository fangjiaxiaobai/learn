package com.fxb.springConfiguration;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author wangxiyue on 2017/9/26 21:55.
 * @description
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println(" 方法执行后   执行，，，，，，");
    }
}
