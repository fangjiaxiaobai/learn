package com.fxb.learn.chapter4feignhystrix.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE-HI")
public interface SchedualServiceHi {

    @RequestMapping(value = "hi")
    String sayHiFromOneClient(@RequestParam(value = "name") String name)
            ;

}
