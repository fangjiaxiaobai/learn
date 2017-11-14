package com.fxb.springSupportMybatis.service;

import com.fxb.springSupportMybatis.dao.CustomerDao;
import com.fxb.springSupportMybatis.dao.CustomerMapper;
import com.fxb.springSupportMybatis.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * @author 方小白 on 2017/9/29 20:44.
 * @description
 */
@Service
public class CustomerService {
    
    
    @Autowired
    private CustomerMapper customerMapper;
    
    public void addCustomer(Customer customer){
        customerMapper.addCustomer(customer);
    }
    
    public Customer getCustomer(Customer customer){
        return customerMapper.getCustomer(customer.getId());
    }
    
    public List<Customer> getCustomers() {
        return customerMapper.getCustomers();
    }
}
