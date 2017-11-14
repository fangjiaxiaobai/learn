package com.fxb.security.service;

import com.fxb.security.dao.AbstractDao;
import com.fxb.security.dao.RoleDao;
import com.fxb.security.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/12 16:55.
 * @description RoleService
 */
@Service
@Transactional
public class RoleService  {
    
    @Autowired
    private RoleDao roleDao;
    
    public Role findById(String id) {
       return  this.roleDao.getByKey(id);
    }
    
    public List<Role> findAll() {
       return this.roleDao.findAll();
    }
}
