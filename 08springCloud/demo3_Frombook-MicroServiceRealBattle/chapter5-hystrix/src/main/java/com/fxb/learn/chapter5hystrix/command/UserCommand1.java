package com.fxb.learn.chapter5hystrix.command;

import com.fxb.learn.chapter5hystrix.entity.User;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/21
 *  创建HyStrix命令的方式一
 */
public class UserCommand1 extends HystrixCommand<User> {
    
    private RestTemplate restTemplate;
    
    private String id;
    
    public UserCommand1(Setter setter, RestTemplate restTemplate, String id) {
        super(setter);
        this.id = id;
        this.restTemplate = restTemplate;
    }
    
    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://SERVICE/users/{1}",User.class,id);
    }
}
