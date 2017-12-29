package com.fxb.learn.feign.service;

import com.fxb.learn.feign.entity.User.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/26
 *
 *      定义HelloService接口，通过@FeignClient注解指定服务名来绑定服务
 *          然后使用SpringMVC的注解来绑定具体该服务提供的REST接口
 */
@FeignClient("hello-SERVICE")
public interface HelloService {
    
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    String hello();
    
    @RequestMapping(value = "hello1",method = RequestMethod.GET)
    String hello(@RequestParam("username")String username);
    
    @RequestMapping(value = "hello2",method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name,@RequestHeader("id")String id);
    
    @RequestMapping(value = "hello3",method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
