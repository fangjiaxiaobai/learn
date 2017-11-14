package com.fxb.chapter7regexAdvisorDemo;

import com.fxb.chapter6staticAdvisorDemo.advisor.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 方小白 on 2017/9/27 20:11.
 * @description
 */
public class DemoTest {
    String configPath = "classpath:/applicationContext.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    
    @Test
    public void test1() {
        Waiter waiter = (Waiter) ctx.getBean("regexp_waiter");
        waiter.greetTo("John");
        waiter.serveTo("John");
    }
}
