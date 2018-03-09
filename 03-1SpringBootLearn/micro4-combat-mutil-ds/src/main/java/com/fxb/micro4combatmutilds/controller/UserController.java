package com.fxb.micro4combatmutilds.controller;

import com.fxb.micro4combatmutilds.model.User;
import com.fxb.micro4combatmutilds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
@RequestMapping("user")
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @ResponseBody
    @RequestMapping("find")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }
    
    @ResponseBody
    @RequestMapping("find2")
    public List<User> findAllUser2(){
        return userService.findAllUser();
    }
}
