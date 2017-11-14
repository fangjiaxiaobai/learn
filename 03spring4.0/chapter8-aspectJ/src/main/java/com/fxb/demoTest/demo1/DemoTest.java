package com.fxb.demoTest.demo1;

import com.fxb.aspectj.PreGreetingAspect;
import com.fxb.target.NaiveWaiter;
import com.fxb.target.Waiter;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 方小白 on 2017/9/27 21:28.
 * @description
 */
public class DemoTest {
    
    String configPath = "classpath:/applicationContext.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    
    @Test
    public void test1() {
        Waiter waiter = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(waiter);
        factory.addAspect(PreGreetingAspect.class);
        Waiter waiterProxy = factory.getProxy();
        waiterProxy.greetTo("John1");
        waiterProxy.serveTo("John1");
    }
    
    @Test
    public void test2(){

        Waiter waiter = (Waiter) ctx.getBean("waiter1");
        waiter.greetTo("Tom2");
    }
    
    @Test
    public void test3() throws Exception{
        Waiter waiter1 = (Waiter) ctx.getBean("waiter1");
        waiter1.throwsTo();
    }
    
}
