package com.fxb.springSupportMybatis.controller;

import com.fxb.springSupportMybatis.entity.Customer;
import com.fxb.springSupportMybatis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author 方小白 on 2017/9/29 20:45.
 * @description
 */
@Controller
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    public void addCustomer(Customer customer){
        this.customerService.addCustomer(customer);
    }

    public Customer getCustomer(Customer customer){
        return this.getCustomer(customer);
    }
    
    public List<Customer> getCustomers() {
        return this.customerService.getCustomers();
    }
}
