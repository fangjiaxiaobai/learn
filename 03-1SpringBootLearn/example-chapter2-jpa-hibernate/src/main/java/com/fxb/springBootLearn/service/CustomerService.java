package com.fxb.springBootLearn.service;

import com.fxb.springBootLearn.dao.CustomerDao;
import com.fxb.springBootLearn.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 方小白 on 2017/9/13 19:53.
 * @description
 */

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public Customer save(Customer c){
       return this.customerDao.save(c);
    }
}
