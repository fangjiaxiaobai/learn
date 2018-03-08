package com.fxb.hotswap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/8
 */
@RestController
public class HelloController {
    
    @RequestMapping(value={"hello","hello2"})
    public String hello(){
        return "hello  456789";
    }
    
}
