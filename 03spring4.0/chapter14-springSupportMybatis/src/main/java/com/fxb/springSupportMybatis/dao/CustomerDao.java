package com.fxb.springSupportMybatis.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 方小白 on 2017/9/29 20:39.
 * @description
 */
public class CustomerDao {
    
    @Autowired
    private SqlSessionTemplate sessionTemplate;
    
    
}
