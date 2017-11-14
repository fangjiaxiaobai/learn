package com.fxb.springSupportMybatis;

import com.fxb.springSupportMybatis.controller.CustomerController;
import com.fxb.springSupportMybatis.entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 方小白 on 2017/9/29 21:21.
 * @description
 */
public class TestCustomerContoller {
    
    CustomerController customerController = null;
    
    @Before
    public void beforeTest(){
        String configPath = "classpath:/spring/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        customerController = (CustomerController) ctx.getBean("customerController");
    }
    
    @Test
    public void test1(){
        Customer customer = new Customer();
        customer.setAge(12);
        customer.setName("fangxiaobai");
        customerController.addCustomer(customer);
        List<Customer> findCustomer = customerController.getCustomers();
        System.out.println(customer);
    }
    
}
