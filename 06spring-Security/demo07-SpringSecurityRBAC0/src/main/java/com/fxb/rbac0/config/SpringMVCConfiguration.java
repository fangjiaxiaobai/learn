package com.fxb.rbac0.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @CLASSNAME: SpringMVCConfiguration
 * @AUTHOR: fangjiaxiaobai
 * @DATETIME: 2017-11-16 00:01
 * @DESCRIPTiONS:
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.fxb.rbac0.controller",useDefaultFilters = false,
includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class SpringMVCConfiguration {
    //Spring MVC 的相关配置。

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
