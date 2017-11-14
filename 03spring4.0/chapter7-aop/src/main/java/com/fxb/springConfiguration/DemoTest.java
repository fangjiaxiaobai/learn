package com.fxb.springConfiguration;

import com.fxb.beforeAdvice.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 方小白 on 2017/9/26 21:30.
 * @description
 */
public class DemoTest {
    
    String configPath = "classpath:/applicationContext.xml";
     ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
 
     /**
     * 前置增强
     * 后置增强
     */
    @Test
    public void test1(){
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("john");
    }
    
    /**
     * 环绕增强
     */
    @Test
    public void test2(){
        Waiter waiter = (Waiter) ctx.getBean("waiter_interceptor");
        waiter.greetTo("john2");
    }
    
    @Test
    public void test3(){
        Waiter waiter = (Waiter) ctx.getBean("waiter_throws");
        waiter.throwsTo("异常测试。");
    }
    
    
}
