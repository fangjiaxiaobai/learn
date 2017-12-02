package com.fxb.learn.chapter9serverzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer // 开启zipkin功能
public class Chapter9ServerZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter9ServerZipkinApplication.class, args);
	}
}
