package com.fxb.security.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author fangxiaobai
 * @date 2017/11/12 18:32.
 * @description SpringConfiguration
 */
@Configuration
@ComponentScan(basePackages = {"com.fxb.security"},excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class, EnableWebMvc.class})})
public class SpringConfiguration{
}