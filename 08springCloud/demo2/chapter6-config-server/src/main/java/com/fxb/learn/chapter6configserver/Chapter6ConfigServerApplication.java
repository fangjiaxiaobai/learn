package com.fxb.learn.chapter6configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class Chapter6ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter6ConfigServerApplication.class, args);
	}
}
