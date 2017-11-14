package com.fxb.springBootLearn.config;

import com.fxb.springBootLearn.filter.MyFilter;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangxiyue on 2017/9/15 11:58.
 * @description
 */
@Configuration
public class WebConfiguartion {
    
    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }
    
    @Bean
    public FilterRegistrationBean testFilterRegistration(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("paramName","paramValue");
        registrationBean.setName("myFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }
    
}
