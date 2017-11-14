package com.fxb.Security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author fangxiaobai
 * @date 2017/11/8 10:44.
 * @description SpringSecurityConfig
 */
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("user").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("dba").password("123").roles("DBA");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/home").access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
                .and()
                    .formLogin().usernameParameter("username").passwordParameter("password")
                    .loginPage("/loginPage").loginProcessingUrl("/j_spring_security_check").successForwardUrl("/home")
                    .failureUrl("/loginPage?error")
                .and()
                    .logout().logoutUrl("/logout").logoutSuccessUrl("/loginPage?logout")
                .and()
                .exceptionHandling().accessDeniedPage("/Access_Denied");
                
    }
}

/*
//相当于以下配置
 <http auto-config="true" >
        <intercept-url pattern="/"     access="hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')" />
        <intercept-url pattern="/home" access="hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')" />
        <form-login  login-page="/login"
                     username-parameter="ssoId"
                     password-parameter="password"
                     authentication-failure-url="/Access_Denied" />
    </http>
 
    <authentication-manager >
        <authentication-provider>
            <user-service>
                <user name="yiibai"  password="123456"  authorities="ROLE_USER" />
                <user name="admin" password="123456" authorities="ROLE_ADMIN" />
                <user name="dba"   password="123456" authorities="ROLE_ADMIN,ROLE_DBA" />
            </user-service>
        </authentication-provider>
    </authentication-manager>
     
 */