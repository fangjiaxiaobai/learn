package com.fxb.learn.chapter5hystrix.controller;

import com.fxb.learn.chapter5hystrix.command.UserCommand1;
import com.fxb.learn.chapter5hystrix.entity.User;
import com.fxb.learn.chapter5hystrix.service.UserService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/21
 */
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    
    @RequestMapping("/users/{id}")
    public String getUserById(@PathVariable("id") String id){
        // 同步执行
        User user = new UserCommand1(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("user"))
            .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(5000))
            , new RestTemplate(), "2").execute();
    /**
     *  // 异步执行。
        Future<User> user1 = new UserCommand1(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("user"))
                                                  .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(5000))
            , new RestTemplate(), "2").queue();
            */
        return user.toString();
        
    }
    
    @RequestMapping("/hello/{username}")
    public String hello(@PathVariable("username") String username){
        return this.userService.hello("使用了注解方式的熔断保护机制-同步执行方式，传入的参数为："+username);
    }
    
    @RequestMapping("/helloAsync/{username}")
    public String helloAsync(@PathVariable("username") String username){
        return this.userService.helloAsync("使用了注解方式的熔断保护机制-异步执行方式，传入的参数为："+username);
    }
    
}
