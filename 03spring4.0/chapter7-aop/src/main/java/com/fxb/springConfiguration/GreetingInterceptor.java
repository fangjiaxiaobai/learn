package com.fxb.springConfiguration;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author wangxiyue on 2017/9/26 22:00.
 * @description
 */
public class GreetingInterceptor  implements MethodInterceptor {
    
    public Object invoke(MethodInvocation invocation) throws Throwable {
    
        Object[] args = invocation.getArguments();
        String clientName = (String) args[0];
        System.out.println("方法前执行  " + clientName);
        Object obj = invocation.proceed();
        System.out.println("方法后执行  "+ clientName);
        
        return obj;
    }
}
