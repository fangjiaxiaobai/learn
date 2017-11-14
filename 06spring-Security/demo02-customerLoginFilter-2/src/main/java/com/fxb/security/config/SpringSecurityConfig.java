package com.fxb.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author fangxiaobai
 * @date 2017/11/7 20:35.
 * @description SpringSecurityConfig
 */
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter{
    
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("fxb").password("123456").roles("USERS");
        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("123456").roles("ADMIN","DBA");
    }
   
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/","/home").permitAll()
                .antMatchers("/db/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
                .and()
                    .formLogin().loginPage("/login").failureUrl("/login?error")
                    .defaultSuccessUrl("/welcome")
                    .usernameParameter("username").passwordParameter("password")
                    .loginProcessingUrl("/j_spring_security_check")
                .and()
                    .logout().logoutSuccessUrl("/login?logout").logoutUrl("/logout")
                .and()
                    .exceptionHandling().accessDeniedPage("/Access_Denied")
                .and()
                    .csrf();
    }
    
    
}
