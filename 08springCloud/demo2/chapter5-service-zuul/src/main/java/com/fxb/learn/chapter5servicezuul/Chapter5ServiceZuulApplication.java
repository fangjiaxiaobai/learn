package com.fxb.learn.chapter5servicezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy  //开启zuul功能
public class Chapter5ServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter5ServiceZuulApplication.class, args);
	}
}
