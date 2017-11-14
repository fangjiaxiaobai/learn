package com.fxb.springBootLearn.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxiyue on 2017/9/13 20:12.
 * @description
 */
@RestController
public class HelloController {
    private Logger logger =LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    public String helloWorld(){
        logger.debug("访问hello");
        return "hello world!!";
    }

    @RequestMapping("/name/{name}")
    public String helloName(@PathVariable String name){
        logger.debug("访问helloName,Name={}",name);
        logger.info("访问helloName,Name={}",name);

        return "hello "+name;
    }


}
