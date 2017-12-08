package com.fxb.learn.chapterspringbootlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 	SpringBoot的Starter POMs采用Spring-boot-starter-*的命名方式，*代表一个特别的应用功能模块。
 	Springboot主要的就是了解各个功能模块有什么用，怎么用即可。

	启动Spring应用：
 	作为一个java应用程序，可以直接运行main函数
 	也可以mvn spring-boot:run来运行
 	还可以使用mvn install 打包成jar包，然后java -jar xxx.jar 来启动应用。

 */


@SpringBootApplication
public class ChapterSpringbootlearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChapterSpringbootlearnApplication.class, args);
	}
}
