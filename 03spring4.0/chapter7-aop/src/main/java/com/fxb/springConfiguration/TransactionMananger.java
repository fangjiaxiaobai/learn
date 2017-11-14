package com.fxb.springConfiguration;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author wangxiyue on 2017/9/27 9:08.
 * @description
 */
public class TransactionMananger implements ThrowsAdvice{
    // 定义增强逻辑
    // 方法名必须是afterThrowing,方法入参规定如下：前三个入参Method method，Object[] args.Object target是可选的。
    // 三个参数，要么提供要么不提供。
    // 最后一个入参为Throwable或者其子类。
    public void afterThrowing(Method method,Object[] args,Object target,Exception ex) throws Throwable{
        System.out.println("method: " + method.getName());
        System.out.println("抛出异常: "+ex.getMessage());
        System.out.println("成功回滚事务.");
    }
}
