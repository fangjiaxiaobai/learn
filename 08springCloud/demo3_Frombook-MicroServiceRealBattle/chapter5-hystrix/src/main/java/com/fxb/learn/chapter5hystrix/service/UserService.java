package com.fxb.learn.chapter5hystrix.service;

import com.fxb.learn.chapter5hystrix.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/21
 */

@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String hello(String username){
        return restTemplate.getForEntity("http://SERVICE/hello/"+username,String.class).getBody();
    }
    
    public String helloFallBack(String username){
        return "sorry ,error for "+username;
    }
    
    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String helloAsync(String username){
        return new AsyncResult<User>(){
            @Override
            public User invoke() {
                User user = restTemplate.getForObject("http://SERVICE/users/{1}", User.class, username);
                System.out.println(user);
                return user;
            }
        }.invoke().toString();
    }
    
//    @HystrixCommand(observableExecutionMode = ObservableExecutionMode.EAGER) // 表示使用observe方式。
    @HystrixCommand(observableExecutionMode = ObservableExecutionMode.LAZY) // 表示使用toObserve方式。
    public Observable<User> getUserById(String id){
        return Observable.create((subscriber)->{
                try {
                    if (!subscriber.isUnsubscribed()) {
                        User user = restTemplate.getForObject("http://SERVICE/users/{1}", User.class, id);
                        subscriber.onNext(user);
                        subscriber.onCompleted();
                    }
                }catch (Exception e){
                    subscriber.onError(e);
                }
        });
        
    }
    
}
