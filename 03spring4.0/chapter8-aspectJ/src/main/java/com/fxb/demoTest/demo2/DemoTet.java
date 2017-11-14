package com.fxb.demoTest.demo2;

import com.fxb.target.Seller;
import com.fxb.target.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangxiyue on 2017/9/28 14:00.
 * @description
 *         演示 引介增强
 *
 *   假设 希望 NaiveWaiter 能够同时充当售货员的角色，即通过切面技术
 *   为NaiveWaiter新增Seller的实现，
 *
 */
public class DemoTet {
    
    String configPath = "classpath:/applicationContext.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    
    @Test
    public void test1(){
        Waiter waiter = (Waiter) ctx.getBean("waiter1");
        waiter.greetTo("引介增强");
        Seller seller = (Seller) waiter;
        seller.sell("引介增强");
    }
}
