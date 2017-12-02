package com.fxb.learn.chapter12hystrixdashboard;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableHystrix   // 开启断路器
@EnableHystrixDashboard  // 开启断路器检测
@RestController
@EnableEurekaClient
@EnableCircuitBreaker
public class Chapter12HystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter12HystrixDashboardApplication.class, args);
	}

	@RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(@RequestParam("name")String name){
	    return "i'm from chapter12-SERVICE-HI,my name is "+name;
    }

    @Value("server.port")
    private String port;

	public String hiError(String name){
        return "i'm from chapter12-SERVICE-HI,my name is "+name +", it's error ";
    }

}
