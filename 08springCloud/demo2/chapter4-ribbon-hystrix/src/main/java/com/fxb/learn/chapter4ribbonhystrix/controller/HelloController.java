package com.fxb.learn.chapter4ribbonhystrix.controller;

import com.fxb.learn.chapter4ribbonhystrix.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService service;

    @RequestMapping("/hi")
    public String hiService(@RequestParam String name){
        return this.service.hiService(name);
    }
}
