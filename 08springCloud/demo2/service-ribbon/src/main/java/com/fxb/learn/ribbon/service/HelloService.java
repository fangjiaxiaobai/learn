package com.fxb.learn.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @CLASSNAME: HelloService
 * @AUTHOR: fangjiaxiaobai
 * @DATETIME: 2017-11-28 22:39
 * @DESCRIPTiONS:
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    public String hiService(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

}
