package com.fxb.rbac0.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;


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
    private Environment element;

    //Spring 容器的配置。
    // dataSource  数据源配置。
    @Bean
    public DataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(element.getProperty("jdbc.url"));
        dataSource.setDriverClassName(element.getProperty("jdbc.driver"));
        dataSource.setUsername(element.getProperty("jdbc.username"));
        dataSource.setPassword(element.getProperty("jdbc.password"));
        return dataSource;
    }
    
    @Bean
    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(getDataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    
    @Bean
    org.apache.ibatis.mapping.Environment getMybatisEnvironment(){
        org.apache.ibatis.mapping.Environment environment = new org.apache.ibatis.mapping.Environment(
                "mybatisSqlSession",null,getDataSource()
        );
        return environment;
    }

}



