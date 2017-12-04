package com.fxb.learn.chapter13serviceturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/*

看单个的Hystrix Dashboard的数据并没有什么多大的价值，
要想看这个系统的Hystrix Dashboard数据就需要用到Hystrix Turbine。
Hystrix Turbine将每个服务Hystrix Dashboard数据进行了整合。
Hystrix Turbine的使用非常简单，只需要引入相应的依赖和加上注解和配置就可以了。
 */

@SpringBootApplication
@EnableTurbine // 开启turbine，同时也开启了DiscoverClient
public class Chapter13ServiceTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter13ServiceTurbineApplication.class, args);
	}
}
