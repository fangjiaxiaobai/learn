package com.fxb.schema;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangxiyue on 2017/9/28 15:22.
 * @description
 */
public class DemoTest {
    
    String configPath = "classpath:/applicationContext-schema.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    
    
    @Test
    public void test1(){
        Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");
        Waiter naughtWaiter = (Waiter) ctx.getBean("naughtWaiter");
        naiveWaiter.greetTo("john");
//        naughtWaiter.greetTo("Tom");
    }
}
