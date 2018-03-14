package com.fxb.micro3componentmybatis.controller;

import com.fxb.micro3componentmybatis.model.User;
import com.fxb.micro3componentmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/8
 */
@RestController
@RequestMapping(value = {"user"})
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/add",produces = {"application/json;charaset=UTF-8"})
    @ResponseBody
    public int addUser(User user){
        return userService.addUser(user);
    }
    
    @RequestMapping(value = "/findAll/{pageNum}/{pageSize}",produces = {"application/json;charset=utf-8"})
    public List<User> findAllUser(@PathVariable("pageNum")int pageNum,@PathVariable int pageSize){
        return this.userService.findAllUser(pageNum,pageSize);
    }
    
}
