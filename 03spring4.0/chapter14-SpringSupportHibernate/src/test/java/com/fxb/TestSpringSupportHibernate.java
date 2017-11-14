package com.fxb;

import com.fxb.springSupportHibernate.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangxiyue on 2017/9/29 17:28.
 * @description
 */
public class TestSpringSupportHibernate {
    
    String configPath = "classpath:applicationContext.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    UserController userController = null;
    
    @Before
    public void beforeTest(){
        userController = (UserController) ctx.getBean("userController");
    }
    
    @Test
    public void testAddUser(){
        userController.testAddUser();
        userController.findAll();
        userController.testDeleteUser();
        userController.testUpdateUser();
        userController.findAll();
    }
    
    
     
    
}
