package com.fxb.rbac0.services;

import com.fxb.rbac0.dao.UserDao;
import com.fxb.rbac0.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/21 18:27.
 * @description UserService
 */
@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserDao userDao;
    
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
    
    public List<User> findAll(User user) {
        return this.userDao.findAll(user);
    }
    
    public void save(User user) {
        this.userDao.save(user);
    }
    
    public void delete(User user) {
        this.userDao.delete(user);
    }
}
