package com.fxb.rbac0.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.lang.reflect.Field;

/**
 * @CLASSNAME: SpringConfiguration
 * @AUTHOR: fangjiaxiaobai
 * @DATETIME: 2017-11-16 00:00
 * @DESCRIPTiONS:
 */
@Configuration
@ComponentScan(basePackages = "com.fxb.rbac0",useDefaultFilters = true,
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
@PropertySource("classpath:application.properties")
public class SpringConfiguration {

    @Autowired
    private Element element;

    //Spring 容器的配置。
    @Bean
    public DataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(Properti);
        dataSource.setDriverClassName();
        dataSource.setUsername();
        dataSource.setPassword();
        return dataSource;
    }

}



