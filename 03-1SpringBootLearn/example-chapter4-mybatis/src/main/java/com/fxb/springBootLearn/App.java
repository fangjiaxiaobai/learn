package com.fxb.springBootLearn;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@MapperScan("com.fxb.springBootLearn.mapper")
@EnableTransactionManagement // 启动事务管理，相当于在xml中 <tx:annotation-driven />配置。
public class App {
    
    private static Logger logger = LoggerFactory.getLogger( App.class );
    
    public static void main( String[] args ) {
        SpringApplication.run( App.class, args );
        logger.info( "SpringBoot Start Success......." );
    }
    
    @Bean
    @ConfigurationProperties("spring.dataSource")
    public DataSource dataSource() {
        return new DataSource();
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource( dataSource() );
        
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        
        sqlSessionFactoryBean.setMapperLocations( resolver.getResources( "classpath:/mybatis/*.xml" ) );
        
        return sqlSessionFactoryBean.getObject();
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        
        return new DataSourceTransactionManager( dataSource() );
    }
}
