package com.fxb.rbac0.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

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
public class SpringMVCConfiguration implements WebMvcConfigurer {
    //Spring MVC 的相关配置。

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        
    }
    
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        
    }
    
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        
    }
    
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        
    }
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/lib/**").addResourceLocations("/lib/");
    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        
    }
    
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        
    }
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        
    }
    
    @Override
    public void addReturnValueHandlers(List <HandlerMethodReturnValueHandler> handlers) {
        
    }
    
    @Override
    public void configureMessageConverters(List <HttpMessageConverter<?>> converters) {
        
    }
    
    @Override
    public void extendMessageConverters(List <HttpMessageConverter <?>> converters) {
        
    }
    
    @Override
    public void configureHandlerExceptionResolvers(List <HandlerExceptionResolver> resolvers) {
        
    }
    
    @Override
    public void extendHandlerExceptionResolvers(List <HandlerExceptionResolver> resolvers) {
        
    }
}
