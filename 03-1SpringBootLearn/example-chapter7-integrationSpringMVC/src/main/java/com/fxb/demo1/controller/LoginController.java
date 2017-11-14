package com.fxb.demo1.controller;

import com.fxb.demo1.entity.User;
import com.fxb.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fangxiaobai on 2017/10/19 20:48.
 * @description
 *
 *         注意：在IDE中直接运行当前启动类，
 *         基于Spring Boot应用在开发调试的时候，一定要基于Spring boot提供的Spring-boot-maven-plugin
 *    插件命令来运行应用或通过Spring boot命令来运行应用、
 */

@Controller
public class LoginController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = {"/","login"})
    public String loginPage(){
        return "login";
    }
    
    
    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request,User user){
        userService.login();
        return new ModelAndView("index").addObject("user",user);
    }
    
    
    
    
}
