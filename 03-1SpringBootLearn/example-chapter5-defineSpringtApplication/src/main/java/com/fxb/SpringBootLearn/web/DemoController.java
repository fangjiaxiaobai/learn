package com.fxb.SpringBootLearn.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxiyue on 2017/9/14 17:12.
 * @description
 */
@RequestMapping("/demo/")
@RestController
public class DemoController {
    
    @Value("${application.name}")
    private String name;
    
    @Value("${application.name}")
    private String name2;
    
    @RequestMapping({"","show"})
    public String show(){
        return this.name;
    }
}
