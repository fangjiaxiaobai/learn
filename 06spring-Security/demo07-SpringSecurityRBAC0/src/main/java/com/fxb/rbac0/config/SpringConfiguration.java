package com.fxb.rbac0.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.fxb.rbac0.common.annotation.MyBatisDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
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
public class SpringConfiguration implements EnvironmentAware {

    @Autowired(required = true)
    private Environment environment;
    
    @Override
    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
    
    //Spring 容器的配置。
    // dataSource  数据源配置。
    @Bean
    public DataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        return dataSource;
    }
    
    // mybatis  SessionFactory
    @Bean
    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(getDataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.fxb.rbac0.dao");
        mapperScannerConfigurer.setAnnotationClass(MyBatisDao.class);
        return mapperScannerConfigurer;
    }
    
    @Bean
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        
        transactionManager.setDataSource(getDataSource());
        return transactionManager;
    }
    
    
    
}



