package com.fxb.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author fangxiaobai
 * @date 2017/11/8 14:11.
 * @description SecurityConfiguration
 */

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private CustomSuccessHandler customSuccessHandler;
    
    
    public void configGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

    }
  
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("fxb").password("123456").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("123456").roles("ADMIN","DBA");
    
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/","/home").access("hasRole('ROLE_USER')")
                    .antMatchers("/admin**").access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/db**").access("hasRole('ROLE_DBA') and hasRole('ROLE_ADMIN')")
                .and().formLogin()
                    .usernameParameter("username").passwordParameter("password")
                    .loginPage("/login").successHandler(customSuccessHandler)
                    .loginProcessingUrl("/j_spring_security_check")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}
