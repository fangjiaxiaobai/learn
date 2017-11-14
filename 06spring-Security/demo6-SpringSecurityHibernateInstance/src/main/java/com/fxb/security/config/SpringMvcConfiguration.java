package com.fxb.security.config;

import com.fxb.security.config.converter.RoleToUserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/12 16:40.
 * @description SpringMvcConfiguration
 */
@Configuration
@EnableWebMvc
//@Import(SecurityConfiguration.class)
@ComponentScan(value = "com.fxb.security.controller",useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class SpringMvcConfiguration implements WebMvcConfigurer {
    @Autowired
    RoleToUserConverter roleToUserConverter;
    
    
    /**
     * 重写父类方法
     *     设置视图解析器
     *     Configure ViewResolvers to deliver preferred views.
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }
    
    /**
     *  处理静态资源
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
    
    /**
     *  配置转换器
     * Configure Converter to be used
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(roleToUserConverter);
    }
    
    /**
     *  配置消息国际化
     *  Configure MessageSource to lookup any validation/error message in internationalized property files
     * @return
     */
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
    
    /**
     * Optional. It's only required when handling '.' in @PathVariables which otherwise ignore everything after last '.' in @PathVaidables argument.
     * It's a known bug in Spring [https://jira.spring.io/browse/SPR-6164], still present in Spring 4.1.7.
     * This is a workaround for this issue.
     * @param matcher
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer matcher){
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }
    
    /**
     * 配置内容裁决解析器 ： 用来配置内容裁决的一些参数。
     *
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true)  // 是否通过请求URL的扩展名来决定mediaType
                .ignoreAcceptHeader(true) // 不检查accept请求头。
                .parameterName("mediaType") //
//                .defaultContentType(MediaType.TEXT_HTML) //  使用默认的MediaType
                .mediaType("html",MediaType.TEXT_HTML)  //请求以.html结尾的会被当做mediaType.TEXT_HTML
                .mediaType("json",MediaType.APPLICATION_JSON_UTF8); // 请求以.json结尾的会被当成MediaType.APPLICATION_JSON
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        
    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        
    }
    
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        
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
    public Validator getValidator() {
        return null;
    }
    
    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
