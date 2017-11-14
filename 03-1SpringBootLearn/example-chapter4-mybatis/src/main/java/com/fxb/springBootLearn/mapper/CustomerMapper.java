package com.fxb.springBootLearn.mapper;

import com.fxb.springBootLearn.entity.Customer;

import java.util.List;

/**
 * @author 方小白 on 2017/9/14 14:07.
 * @description
 */
public interface CustomerMapper {

    public List<Customer> findAll();

}
