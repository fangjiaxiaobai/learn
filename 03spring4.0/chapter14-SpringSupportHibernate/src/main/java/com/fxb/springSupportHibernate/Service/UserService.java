package com.fxb.springSupportHibernate.Service;

import com.fxb.springSupportHibernate.dao.UserDao;
import com.fxb.springSupportHibernate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 方小白 on 2017/9/29 17:08.
 * @description
 */

@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserDao userDao;
    
    public void addUser(User user){
        userDao.addUser(user);
    }
    
    public User findUser(User user){
        return userDao.findUser(user);
    }
    
    public void deleteUser(User user){
        userDao.deleteUser(user);
    }
    
    public void updateUser(User user){
        userDao.updateUser(user);
    }
    
    public List<User> findAll(){
        return userDao.findAllUSer();
    }
    
}
