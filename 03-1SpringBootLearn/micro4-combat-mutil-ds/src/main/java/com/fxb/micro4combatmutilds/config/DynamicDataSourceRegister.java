package com.fxb.micro4combatmutilds.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 注册在application.properties配置的多数据源。重点！
 * 动态数据源注册
 *
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    
    private Logger logger=LoggerFactory.getLogger(DynamicDataSourceRegister.class);
    
    // 如果 配置文件中未指定数据源类型，就使用默认配置
    private static final Object DATASOURCE_TYPE_DEFAULT="com.alibaba.druid.pool.DruidDataSource";
    private ConversionService conversionService=new DefaultConversionService();
    private PropertyValues dataSourcePropertyValues;
    
    // 默认数据源
    private DataSource defaultDataSource;
    
    private Map<String, DataSource> customDataSources=new HashMap<>();
    
    /**
     * 加载多数据源配置
     *
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        logger.info("DynamicdataSourceRegister setEnvironment");
        initializeDefaultDataSource(environment);
        initializeCustomDataSource(environment);
    }
    
    /**
     * 初始化更多数据源
     * @param environment
     */
    private void initializeCustomDataSource(Environment environment) {
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment,"custom.dataSource.");
        String names=propertyResolver.getProperty("names");
        for (String name : names.split(",")) {
            Map<String, Object> dsMap=propertyResolver.getSubProperties(name + ".");
            DataSource ds=buildDataSource( dsMap);
            customDataSources.put(name,ds);
            dataBinder(ds,environment);
        }
    }
    
    /**
     * 加载主数据源
     *
     * @param environment
     */
    private void initializeDefaultDataSource(Environment environment) {
        RelaxedPropertyResolver relaxedPropertyResolver=new RelaxedPropertyResolver(environment, "spring.dataSource.");
        HashMap<String, Object> dsMap=new HashMap<>();
        dsMap.put("type", relaxedPropertyResolver.getProperty("type"));
        dsMap.put("driverClassName", relaxedPropertyResolver.getProperty("driverClassName"));
        dsMap.put("url", relaxedPropertyResolver.getProperty("url"));
        dsMap.put("username", relaxedPropertyResolver.getProperty("username"));
        dsMap.put("password", relaxedPropertyResolver.getProperty("password"));
        
        defaultDataSource=buildDataSource(dsMap);
        dataBinder(defaultDataSource, environment);
        
    }
 
    
    private DataSource buildDataSource(Map<String, Object> dsMap) {
        Object type=dsMap.get("type");
        if (null == type) {
            type=DATASOURCE_TYPE_DEFAULT; //默认数据源
        }
        Class<? extends DataSource> dataSourceType;
        
        try {
            dataSourceType=(Class<? extends DataSource>) Class.forName((String) type);
            String url=dsMap.get("url").toString();
            String username=dsMap.get("username").toString();
            String password=dsMap.get("password").toString();
            String driverClassName=dsMap.get("driverClassName").toString();
//            DataSourceBuilder factory=DataSourceBuilder.create().driverClassName(driverClassName)
//                .url(url).username(username).password(password).type(dataSourceType);
            DruidDataSourceBuilder druidDataSourceBuilder=DruidDataSourceBuilder.create();
            DruidDataSource build=druidDataSourceBuilder.build();
            build.setUsername(username);
            build.setPassword(password);
            build.setUrl(url);
            build.setDriverClassName(driverClassName);
//            build.setDriverClassLoader(dataSourceType.getClassLoader());
    
            return build;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    private void dataBinder(DataSource dataSource, Environment environment) {
        RelaxedDataBinder dataBinder = new RelaxedDataBinder(dataSource);
        dataBinder.setConversionService(conversionService);
        dataBinder.setIgnoreInvalidFields(false);
        dataBinder.setIgnoreNestedProperties(false);
        dataBinder.setIgnoreUnknownFields(true);
        
        if(null==dataSourcePropertyValues){
            Map<String, Object> subProperties=new RelaxedPropertyResolver(environment, "spring.dataSource").getSubProperties(".");
            HashMap<String, Object> values=new HashMap<>();
            values.remove("type");
            values.remove("driverClassName");
            values.remove("url");
            values.remove("username");
            values.remove("password");
            dataSourcePropertyValues=new MutablePropertyValues(values);
        }
        dataBinder.bind(dataSourcePropertyValues);
    }
    
    
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        logger.info("dynamicDataSourceRegister registerBeanDefinitions");
    
        HashMap<String, Object> targetDataSources=new HashMap<>();
        targetDataSources.put("dataSource",defaultDataSource);
        DynamicDataSourceHolder.dataSourceIds.add("dataSource");
        // 添加更多数据源
        targetDataSources.putAll(customDataSources);
        for (String key : customDataSources.keySet()) {
            DynamicDataSourceHolder.dataSourceIds.add(key);
        }
    
        //创建 DynamicDataSource
        GenericBeanDefinition beanDefinition=new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        
        beanDefinition.setSynthetic(true);
        MutablePropertyValues propertyValues=beanDefinition.getPropertyValues();
        // 添加属性
        propertyValues.addPropertyValue("defaultTargetDataSource",defaultDataSource);
        propertyValues.addPropertyValue("targetDataSource",targetDataSources);
        beanDefinitionRegistry.registerBeanDefinition("dataSource",beanDefinition);
    }
}
