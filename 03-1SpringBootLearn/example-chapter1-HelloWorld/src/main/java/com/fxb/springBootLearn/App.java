package com.fxb.springBootLearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangxiyue on 2017/9/14 21:14.
 * @description
 */
@SpringBootApplication
public class App {
    
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
        logger.info("App  startted ........ ");
    }
}
