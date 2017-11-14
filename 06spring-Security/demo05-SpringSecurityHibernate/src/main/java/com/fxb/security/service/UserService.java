package com.fxb.security.service;

import com.fxb.security.dao.UserDao;
import com.fxb.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fangxiaobai
 * @date 2017/11/8 21:18.
 * @description UserService
 */
@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User findById(String id){
        return this.userDao.getByKey(id);
    }
    
    public User findByUsename(String username){
        return this.userDao.findByName(username);
    }
    
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userDao.save(user);
    }
}
