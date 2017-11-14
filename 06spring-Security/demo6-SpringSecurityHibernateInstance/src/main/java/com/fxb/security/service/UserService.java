package com.fxb.security.service;

import com.fxb.security.dao.UserDao;
import com.fxb.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/12 15:51.
 * @description UserService
 */
@Transactional
@Service
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
    
    public User findById(String id) {
        return this.userDao.getByKey(id);
    }
    
    public void deleteById(String id) {
        User user = new User();
        user.setId(id);
        this.userDao.delete(user);
    }
}
