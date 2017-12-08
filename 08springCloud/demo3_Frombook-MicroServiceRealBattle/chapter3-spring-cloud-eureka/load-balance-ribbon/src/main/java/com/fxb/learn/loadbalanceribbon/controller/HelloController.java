package com.fxb.learn.loadbalanceribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/7
 */
@RestController
public class HelloController {
    @Autowired
    public RestTemplate restTemplate;
    
    @RequestMapping("/hello/")
    public String hello(@RequestParam("username") String username){
        return restTemplate.getForObject("Http://EUREKA-CLIENT/hello/"+username,String.class);
    }
    
}
