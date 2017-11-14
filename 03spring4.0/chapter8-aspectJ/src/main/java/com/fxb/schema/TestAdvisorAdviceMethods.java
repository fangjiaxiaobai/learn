package com.fxb.schema;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author wangxiyue on 2017/9/28 15:46.
 * @description
 */
public class TestAdvisorAdviceMethods implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("--- TestAdvisorAdviceMethods  start ---");
        System.out.println("clientName:"+args[0]);
        System.out.println("--- TestAdvisorAdviceMethods  end ---");
    }
}
