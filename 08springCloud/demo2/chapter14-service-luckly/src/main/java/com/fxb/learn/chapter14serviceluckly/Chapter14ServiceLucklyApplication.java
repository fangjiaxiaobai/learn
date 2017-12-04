package com.fxb.learn.chapter14serviceluckly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
public class Chapter14ServiceLucklyApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter14ServiceLucklyApplication.class, args);
	}

	@RequestMapping(value = "/hi")
	public String hi(@RequestParam("name") String name){
	    return "my name is "+name+" i'm from service-luck";
    }
}
