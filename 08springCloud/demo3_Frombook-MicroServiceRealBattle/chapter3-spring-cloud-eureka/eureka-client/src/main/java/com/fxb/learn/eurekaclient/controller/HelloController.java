package com.fxb.learn.eurekaclient.controller;

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
        return "hello "+username+"  ,i'm from server-client1,port=8010";
    }
}
