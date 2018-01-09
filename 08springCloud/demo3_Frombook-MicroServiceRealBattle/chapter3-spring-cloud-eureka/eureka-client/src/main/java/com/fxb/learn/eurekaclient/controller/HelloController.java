package com.fxb.learn.eurekaclient.controller;

import com.fxb.learn.eurekaclient.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/7
 */
@RestController
@RequestMapping("/")
public class HelloController {
    
    @RequestMapping("/hello/{username}")
    public String hello(@PathVariable("username") String username){
        return "hello "+username+"  ,i'm from server-client1,port=8010";
    }
    
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){
        return "hello world";
    }
    /**
     * 练习Feign
     * @param username
     * @return
     */
    @RequestMapping("/hello1")
    public String hello1(String username){
        return "hello "+username+"  ,i'm from server-client1,port=8010";
    }
    
    
    
    /**
     * 2017-12-26 练习Feign
     * @param name
     * @param id
     * @return
     */
    @RequestMapping("/hello2")
    public User hello2(@RequestHeader String name,@RequestHeader String id){
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        return user;
    }
    
    /**
     * 2017-12-26 练习Feign
     * @param user
     * @return
     */
    @RequestMapping("/hello3")
    public String hello3(@RequestBody User user){
        return "hello3 "+user.getId()+","+user.getUsername();
    }
    
    /**
     * 2017-12-21 练习服务容错保护。
     * @param id
     * @return
     */
    @RequestMapping("/users/{id}")
    public String getUserById(@PathVariable("id") String id){
        User user = new User();
        user.setId(id);
        user.setUsername("王粟");
        return user.toString();
    }
    
    
}
