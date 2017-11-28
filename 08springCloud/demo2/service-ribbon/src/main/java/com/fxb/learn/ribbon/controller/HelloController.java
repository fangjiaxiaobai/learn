package com.fxb.learn.ribbon.controller;

import com.fxb.learn.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CLASSNAME: HelloController
 * @AUTHOR: fangjiaxiaobai
 * @DATETIME: 2017-11-28 23:04
 * @DESCRIPTiONS:
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService("fangjiaxiaobai----"+name);
    }

}
