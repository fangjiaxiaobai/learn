package com.fxb.learn.chapter4ribbonhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *  演示在ribbon中使用断路器。
 *  	什么是断路器？
 * 防止服务故障的雪崩。当某个服务出现故障后，再次访问这个服务的时候，就会返回一个特定的值
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class Chapter4RibbonHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter4RibbonHystrixApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate template(){
		return new RestTemplate();
	}
}
