package com.fxb.learn.commonhelloservice.controller;

import com.fxb.learn.commonhelloservice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/27
 */
@RestController
@RequestMapping("/")
public class HelloController {
    
    @Autowired
    private HelloService helloService;
    
    @RequestMapping("hello")
    public String hello(){
        return helloService.hello();
    }
    
    @RequestMapping("/hello/{username}")
    public String hello(@PathVariable("username") String username){
        return this.helloService.hello(username);
    }
    
}
