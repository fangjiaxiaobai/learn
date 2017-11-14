package com.fxb.springBootLearn.web;

import com.fxb.springBootLearn.entity.Customer;
import com.fxb.springBootLearn.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 方小白 on 2017/9/14 14:16.
 * @description
 */

@RestController
@RequestMapping("/customer/")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @RequestMapping("findAll")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

}
