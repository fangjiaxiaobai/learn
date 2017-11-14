package com.fxb.springBootLearn.web;

import com.fxb.springBootLearn.domain.Customer;
import com.fxb.springBootLearn.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


/**
 * @author 方小白 on 2017/9/13 19:54.
 * @description
 */
@RestController
public class CustomerController {
    private static Logger logger =LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping("save")
    public Customer save(){
        logger.info("开始保存");
        Customer c = this.customerService.save(new Customer(null,"姓名2",130));
        logger.info("保存结束");
        return c;
    }


}
