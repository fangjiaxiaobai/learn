package com.fxb.namedPointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author wangxiyue on 2017/9/28 14:34.
 * @description
 */
@Aspect
public class TestNamePointcut {
    
    /**
     * 通过注解方法inPackage()对该切点进行命名，
     * 方法可视域修饰符为private，表明该命名切点只能在本切面类中使用。
      */
    @Pointcut("within(com.fxb.namedPointcut.*)")
    private void inPackage(){}
    
    /**
     * 通过注解方法greetTo() 对该切点进行命名，方法可视域修饰符protected，
     * 表明该命名切点可以在当前包中的切面类，子切面类中使用
     */
    @Pointcut("execution(* greetTo(..))")
    protected  void greetTo(){}
    
    /**
     * 引用命名切点定义的切点，本切点也是命名切点，它对应的可视域为public
     */
    @Pointcut("inPackage() and greetTo()")
    public void inPkgGreetTo(){
        System.out.println("named joinPointcut.......");
    }
    
    
}
