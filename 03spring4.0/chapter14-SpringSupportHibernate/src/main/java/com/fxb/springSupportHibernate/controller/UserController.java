package com.fxb.springSupportHibernate.controller;

import com.fxb.springSupportHibernate.Service.UserService;
import com.fxb.springSupportHibernate.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author 方小白 on 2017/9/29 17:09.
 * @description
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    

    public void testAddUser(){
        User user = new User();
        user.setUsername("fangxiaobai");
        user.setAge(23);
        userService.addUser(user);
    }
    

    public void testUpdateUser(){
        User user = userService.findAll().get(1);
        user.setUsername("wangsu");
        user.setAge(23);
        userService.updateUser(user);
    }
    

    public void testDeleteUser(){
        User user = userService.findAll().get(1);
        userService.deleteUser(user);
    }
    
    public void findAll(){
        System.out.println(userService.findAll());
    }
    
    
}
