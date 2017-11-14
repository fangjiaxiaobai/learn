package com.fxb.security.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author fangxiaobai
 * @date 2017/11/7 19:25.
 * @description SpringMVCConfig
 * <context:component-scan base-package="com.yiibai.web.*" />

    <bean
    class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix">
    <value>/WEB-INF/pages/</value>
    </property>
    <property name="suffix">
    <value>.jsp</value>
    </property>
    </bean>
 */

@EnableWebMvc
@Configuration
@ComponentScan({"com.fxb.security.controller"})
@Import({ SpringSecurityConfig.class})
public class SpringMVCConfig {
    
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
    
}
