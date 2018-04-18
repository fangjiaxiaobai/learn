package com.fxb.relearn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * demo08-relearn --  SpringMVC 配置
 *
 * @author fangjiaxiaobai@163.com
 * @date 2018-04-11
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//         registry.addRedirectViewController("/","home.html");
         registry.addViewController("/").setViewName("home.html");
         registry.addViewController("/hello").setViewName("hello.html");
    }

//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("");
//        resolver.setSuffix(".html");
//        registry.viewResolver(new InternalResourceViewResolver());
//    }
}
