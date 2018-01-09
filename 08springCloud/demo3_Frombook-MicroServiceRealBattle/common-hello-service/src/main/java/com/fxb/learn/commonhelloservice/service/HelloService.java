package com.fxb.learn.commonhelloservice.service;

import org.springframework.stereotype.Service;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/27
 */
@Service
public class HelloService {
    
    public String hello(){
        return "hello";
    }
    
    public String hello(String username){
        return "hello "+username +", from commonHello1";
    }
    
}
