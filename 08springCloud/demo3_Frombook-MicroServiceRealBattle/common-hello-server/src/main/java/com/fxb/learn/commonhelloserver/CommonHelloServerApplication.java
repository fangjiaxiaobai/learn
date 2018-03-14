package com.fxb.learn.commonhelloserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CommonHelloServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonHelloServerApplication.class, args);
	}
}
