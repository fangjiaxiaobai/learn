package com.fxb.learn.enurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EnurekaserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnurekaserviceApplication.class, args);
	}
}
