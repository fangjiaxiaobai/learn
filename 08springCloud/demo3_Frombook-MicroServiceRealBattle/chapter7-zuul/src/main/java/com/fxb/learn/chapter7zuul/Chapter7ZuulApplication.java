package com.fxb.learn.chapter7zuul;

import com.fxb.learn.chapter7zuul.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy   // 开启Zuul的API网关功能
public class Chapter7ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter7ZuulApplication.class, args);
	}
	
	@Bean
	AccessFilter accessFilter(){
	    return  new AccessFilter();
    }
}
