package com.fxb.learn.chapter8configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Chapter8ConfigServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(Chapter8ConfigServerApplication.class, args);
    }
}
