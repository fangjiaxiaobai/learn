package com.fxb.hotswap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 热部署：监听到如果有class文件改动，就会创建一个新的ClassLoader，
 * 进行加载该文件，经过一系列的过程，最终将结果呈现在我们眼前。
 */
@SpringBootApplication
public class HotSwapApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotSwapApplication.class, args);
	}
}
