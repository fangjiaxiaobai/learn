package com.fxb.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangxiyue on 2017/9/23 14:54.
 * @description
 */
public class DemoTest {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        Boss1 boss1 = (Boss1) factory.getBean("boss1");
        boss1.test1();
    }
}
