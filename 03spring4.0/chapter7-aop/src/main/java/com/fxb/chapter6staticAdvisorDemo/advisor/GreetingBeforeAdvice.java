package com.fxb.chapter6staticAdvisorDemo.advisor;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author 方小白 on 2017/9/27 18:58.
 * @description
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"."+method.getName()); // 输出切点。
        String clientName=(String) args[0];
        System.out.println("How are you! Mr."+clientName+".");
    }
}
