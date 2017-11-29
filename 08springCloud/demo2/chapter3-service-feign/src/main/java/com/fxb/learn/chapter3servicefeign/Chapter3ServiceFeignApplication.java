package com.fxb.learn.chapter3servicefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 *  feign是一个声明式的伪客户端。他使得写Http客户端变得简单。
 *  使用Feign，只需要创建一个接口并注解。它具有可插拔的注解特性，可使用Feign注解和JAX-RS注解。
 *  Feig支持可插拔的编码器和解码器。Feign默认集成了Ribbon，并和Eureka结合。
 *  默认实现了负载均衡的效果。
 *
 *      简言之：
 *   Feign 采用的是基于接口的注解。
 *   Feign 默认整合ribbon，实现了负载均衡
 */
@SpringBootApplication
@EnableFeignClients // 开启feign的功能。
@EnableDiscoveryClient
public class Chapter3ServiceFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter3ServiceFeignApplication.class, args);
	}
}
