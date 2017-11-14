package com.fxb.beforeAdvice;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author wangxiyue on 2017/9/26 21:00.
 * @description
 */
public class DemoTest {
    
    @Test
    public void test1(){
        Waiter waiter = new NaiveWaiter();
    
        BeforeAdvice advice = new GreetingBeforeAdvice();
    
        // spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();
        
        // 设置代理目标
        pf.setTarget(waiter);
        
        // 为代理目标添加增强
        pf.addAdvice(advice);
        
        // 生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("Tom");
        proxy.serveTo("Tom");
    }
    
}
