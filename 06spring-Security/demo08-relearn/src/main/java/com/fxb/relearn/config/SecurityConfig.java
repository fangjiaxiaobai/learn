package com.fxb.relearn.config;

import com.fxb.relearn.services.UserDetialsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * demo08-relearn
 *
 * @author fangjiaxiaobai@163.com
 * @date 2018-04-11
 */
@Configuration
@EnableWebSecurity //使SpringMvc集成SpringSecurity的web支持。
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        super.configure(http);

        http.authorizeRequests()
                .antMatchers("/","/login","/home.html").permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin().permitAll()
                .and()
                    .logout().permitAll();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("admin").password("admin").roles("USER");
        auth.userDetailsService(new UserDetialsService()).passwordEncoder(new MyPasswordEncoder());
    }
}
