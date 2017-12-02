package com.fxb.learn.chapter9servicehi;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Chapter9ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter9ServiceHiApplication.class, args);
	}

	@Autowired
	private RestTemplate template;

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

	@RequestMapping("/hi")
	public String callHome(){
		return  template.getForObject("http://localhost:8012/hi",String.class);
	}

	@RequestMapping("/info")
	public String info(){
		return ":hi i'm service-hi";
	}

	/**
	 *  有什么作用呢?
	 * @return
	 */
	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}

}
