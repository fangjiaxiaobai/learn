package com.fxb.learn.chapter5hystrix.command;

import com.fxb.learn.chapter5hystrix.entity.User;
import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/21
 */
public class UserObservableCommand extends HystrixObservableCommand<User> {
    
    private RestTemplate restTemplate;
    
    private String id;
    
    protected UserObservableCommand(Setter setter,RestTemplate restTemplate,String id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }
    
    
    @Override
    protected Observable<User> construct() {
        return Observable.create(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> subscriber) {
                try {
                    if (!subscriber.isUnsubscribed()) {
                        User user = restTemplate.getForObject("http://SERVICE/users/{1}", User.class, id);
                        subscriber.onNext(user);
                        subscriber.onCompleted();
                    }
                }catch (Exception e){
                    subscriber.onError(e);
                }
            }
        });
    }
}
