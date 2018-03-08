package com.fxb.micro3componentmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan("com.fxb.micro3componentmybatis.mapper")
//@Import({DynamicDataSourceRegister.class})
public class Micro3ComponentMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Micro3ComponentMybatisApplication.class, args);
	}
}
