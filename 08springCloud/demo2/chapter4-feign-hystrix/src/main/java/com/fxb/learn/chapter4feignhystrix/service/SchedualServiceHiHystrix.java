package com.fxb.learn.chapter4feignhystrix.service;

import org.springframework.stereotype.Component;

/**
 * 要实现对应的SchedulServiceHi,并且注入到IOC容器中。
 */
@Component
public class SchedualServiceHiHystrix implements SchedualServiceHi{

    @Override
    public String sayHiFromOneClient(String name) {
        return "sorry ! "+ name +" occur !";
    }
}
