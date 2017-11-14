package com.fxb.namedPointcut.demo;

import com.fxb.namedPointcut.TestAspect;
import com.fxb.target.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangxiyue on 2017/9/28 14:44.
 * @description
 */
public class DemoTest {
    
    
    String configPath = "classpath:/applicationContext.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    
    @Test
    
    public void test1(){
        Waiter waiter = (Waiter) ctx.getBean("waiter1");
        waiter.greetTo("john");
    }
}
