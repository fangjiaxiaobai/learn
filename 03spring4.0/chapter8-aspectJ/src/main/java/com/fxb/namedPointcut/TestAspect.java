package com.fxb.namedPointcut;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author wangxiyue on 2017/9/28 14:40.
 * @description
 */
@Aspect
public class TestAspect {
    
    /**
     *   引用TestNamePointcut.inPkgGreetTo()切点。
     */
    @Before("TestNamePointcut.inPkgGreetTo()")
    public void pkgGreetTo(){
        System.out.println("--pkg greetTo() execution!---");
    }
    
    /**
     * 在符合运算中使用命名切点
     */
    @Before("!target(com.fxb.target.NaiveWaiter) && TestNamePointcut.inPkgGreetTo()")
    public void pkgGreetToNotNaiveWaiter(){
        System.out.println("----pkgGreetToNotNaiveWaiter() executed!------");
    }
    
    @Around("execution(* greetTo(..)) && target(com.fxb.target.NaiveWaiter)")
    public void joinPointcutAccess(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("-----------------joinPointAccess  start ----------------------");
    
        System.out.println("args[0]:"+pjp.getArgs()[0]);
        System.out.println("signature:"+pjp.getTarget().getClass());
        pjp.proceed();
        System.out.println("--------joinPointAccess end----------------");
    }
}
