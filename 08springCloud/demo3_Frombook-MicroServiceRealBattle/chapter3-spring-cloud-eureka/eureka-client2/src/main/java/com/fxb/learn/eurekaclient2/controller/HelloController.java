package com.fxb.learn.eurekaclient2.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/7
 */
@RestController
public class HelloController {
    
    @RequestMapping("/hello/{username}")
    public String hello(@PathVariable("username") String username){
    return "hello "+ username + " i'm form server-client2,port=8011";
    }
    
}
