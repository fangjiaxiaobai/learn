package com.fxb.springBootLearn.services;

import com.fxb.springBootLearn.entity.Customer;
import com.fxb.springBootLearn.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 方小白 on 2017/9/14 14:20.
 * @description
 */

@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerDao;


    public List <Customer> findAll(){
        return this.customerDao.findAll();
    }
}
