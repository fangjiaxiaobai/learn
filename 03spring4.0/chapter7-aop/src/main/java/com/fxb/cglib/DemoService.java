package com.fxb.cglib;

import org.junit.Test;

/**
 * @author 方小白 on 2017/9/26 20:30.
 * @description
 */
public class DemoService {
    
    public void demo1() {
        System.out.println(" 被代理的类。。。。。。 ");
    }
    
    @Test
    public void test1() {
        CGLibProxy proxy = new CGLibProxy();
        DemoService demoService = (DemoService) proxy.getProxy(DemoService.class);
        demoService.demo1();
    }
    
    
}
