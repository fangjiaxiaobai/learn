package com.fxb.learn.feign.controller;

import com.fxb.learn.feign.entity.User.User;
import com.fxb.learn.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/26
 */

@RestController
public class ConsumerController {
    
    @Autowired
    private HelloService helloService;
    
    @RequestMapping(value = "/hello")
    public String helloConsumer(){
        return helloService.hello();
    }
    
    @RequestMapping(value = "/hello/{username}",method = RequestMethod.GET)
    public String helloConusmer1(@PathVariable("username") String username){
        return helloService.hello(username);
    }
    
    @RequestMapping(value = "hello2",method = RequestMethod.GET)
    public String helloConsumer2(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("DIDI")).append("\n");
        sb.append(helloService.hello("DIDI","1234566")).append("\n");
        sb.append(helloService.hello(new User("DIDI","1234567893"))).append("\n");
        return sb.toString();
    }
    
    
}
