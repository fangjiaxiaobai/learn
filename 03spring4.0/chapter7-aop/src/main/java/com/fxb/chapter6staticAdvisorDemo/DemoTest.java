package com.fxb.chapter6staticAdvisorDemo;


import com.fxb.chapter6staticAdvisorDemo.advisor.Seller;
import com.fxb.chapter6staticAdvisorDemo.advisor.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 方小白 on 2017/9/27 19:59.
 * @description
 */
public class DemoTest {
    String configPath = "classpath:/applicationContext.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    
    @Test
    public void test1() {
        Waiter waiter = (Waiter) ctx.getBean("waiter_static");
        Seller seller = (Seller) ctx.getBean("seller_static");
        waiter.greetTo("carry");
        waiter.serveTo("carry");
        seller.greetTo("carry");
    }
}
