package com.fxb.learn.chapter4feignhystrix.controller;

import com.fxb.learn.chapter4feignhystrix.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private SchedualServiceHi schedualServiceHi;

    @RequestMapping("/hi")
    public String hi(String name){
        return this.schedualServiceHi.sayHiFromOneClient(name);
    }

}
