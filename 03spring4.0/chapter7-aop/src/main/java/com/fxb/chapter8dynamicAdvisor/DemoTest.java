package com.fxb.chapter8dynamicAdvisor;

import com.fxb.chapter6staticAdvisorDemo.advisor.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 方小白 on 2017/9/27 20:38.
 * @description
 */
public class DemoTest {
    
    String configPath = "classpath:/applicationContext.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    
    @Test
    public void test1() {
        Waiter waiter = (Waiter) ctx.getBean("dynamic_waiter");
        waiter.greetTo("方小白");
        waiter.serveTo("方小白");
        waiter.greetTo("Tom");
        waiter.serveTo("Tom");
    }
}
