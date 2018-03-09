package com.fxb.micro4combatmutilds;

import com.fxb.micro4combatmutilds.config.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * spring boot切换多数据源实战：
 *  1、搭建spring boot开发环境。
 *  2.配置依赖
 *  3.编写配置文件
 *  4.编写动态数据源类
 *  5.注册多数据源
 *  6.测试
 *  动态数据源能进行自动切换的核心就是spring底层提供了AbstractRoutingDataSource类进行数据源的路由的，
 *  我们主要继承这个类，实现里面的方法即可实现我们想要的，这里主要是实现方法：determineCurrentLookupKey（），
 *  而此方法只需要返回一个数据库的名称即可，所以我们核心的是有一个类来管理数据源的线程池，
 *  这个类才是动态数据源的核心处理类。还有另外就是我们使用aop技术在执行事务方法前进行数据源的切换。
 */
@SpringBootApplication
@Import({DynamicDataSourceRegister.class})
public class Micro4CombatMutilDsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Micro4CombatMutilDsApplication.class, args);
	}
}
