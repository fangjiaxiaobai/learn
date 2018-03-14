package com.fxb.learn.chapter8configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangjiaxiaobai
 * @date 2018/1/4
 */
@RestController
@RefreshScope
public class TestController {
    
    @Value("${from}")
    private String from;
    
    @RequestMapping("from")
    public String from(){
        return this.from;
    }
    
}
