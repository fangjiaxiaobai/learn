package com.fxb.springSupportMybatis.dao;

import com.fxb.springSupportMybatis.entity.Customer;

import java.util.List;

/**
 * @author wangxiyue on 2017/9/29 21:12.
 * @description
 */


public interface CustomerMapper {
    
    public Customer getCustomer(String id);
    
    public void addCustomer(Customer customer);
    
    List<Customer> getCustomers();
}
