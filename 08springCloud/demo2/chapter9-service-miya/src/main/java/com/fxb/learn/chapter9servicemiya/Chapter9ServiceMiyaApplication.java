package com.fxb.learn.chapter9servicemiya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Chapter9ServiceMiyaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter9ServiceMiyaApplication.class, args);
	}

	@RequestMapping("/hi")
	private String home(){
		return ":hi! i'm miya";
	}

	@RequestMapping("/info")
	public String info(){
		return restTemplate.getForObject("http://localhost:8011/info",String.class);
	}

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}



}
