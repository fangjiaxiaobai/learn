package com.fxb.learn.chapter3servicefeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-hi")
@Service
public interface SchedualServiceHi {

    @RequestMapping(value = "hi")
    String sayHiFromOneClient(@RequestParam(value = "name") String name);

}
