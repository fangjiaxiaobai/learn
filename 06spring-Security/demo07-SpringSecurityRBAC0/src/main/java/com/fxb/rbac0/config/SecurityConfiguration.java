package com.fxb.rbac0.config;

import com.fxb.rbac0.common.utils.PrincalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author fangxiaobai
 * @date 2017/11/17 11:45.
 * @description SecurityConfiguration
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    @Autowired
    UserDetailsService userDetailsService;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(getAuthenticationProvider());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/static/**","/lib/**","/js/**","/favicon.ico").permitAll()
                .antMatchers("/login").permitAll()
                .and().headers().frameOptions().sameOrigin()
                .and()
                    .logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout")
                .and()
                    .formLogin().loginPage("/index").usernameParameter("username").passwordParameter("password")
                    .successForwardUrl("/index").loginProcessingUrl("/login").successHandler(getAuthenticationSuccessHandler())
                .and().rememberMe().rememberMeParameter("remember-me").tokenValiditySeconds(86400).tokenRepository(getInmemoryTokenRepositoryImpl())
                .and().csrf().disable()
                .exceptionHandling().accessDeniedPage("/accessDenied");
    }
    
    @Bean
    public AuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
//        authenticationProvider.setSaltSource(getSaltSource());
        return authenticationProvider;
    }
    
    @Bean
    public SaltSource getSaltSource() {
        ReflectionSaltSource saltSource = new ReflectionSaltSource();
        saltSource.setUserPropertyToUse("salt"); // 设置获取salt的方法名。
        return  saltSource;
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    /**
     *  配置Remember-me,保存再内存中。
     *      也可以持久化到数据库中：JdbcTokenRepositoryImpl
     * @return
     */
    @Bean
    public InMemoryTokenRepositoryImpl getInmemoryTokenRepositoryImpl(){
        InMemoryTokenRepositoryImpl inMemory = new InMemoryTokenRepositoryImpl();
        return inMemory;
    }
    
    /**
     *  评估认证的token。
     * @return
     */
    @Bean
    public AuthenticationTrustResolver authenticationTrustResolver(){
        return new AuthenticationTrustResolverImpl();
    }
    
    public AuthenticationSuccessHandler getAuthenticationSuccessHandler(){
        return new SimpleUrlAuthenticationSuccessHandler(){
            RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
            private Logger logger = LoggerFactory.getLogger("SimpleUrlAutenticationSuccessHandler");
    
            @Override
            protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                Collection <? extends GrantedAuthority> authorities = authentication.getAuthorities();
                ArrayList <String> roles = new ArrayList <>();
                for(GrantedAuthority authority : authorities) {
                    roles.add(authority.getAuthority());
                }
                logger.info("用户[{}]拥有权限:" + roles, PrincalUtil.getPrincipal());
                if(roles != null) {
                    logger.info("用户[{}]跳转到: \\index " , PrincalUtil.getPrincipal());
                    redirectStrategy.sendRedirect(request, response, "/index");
                } else {
                    logger.info("用户[{}]跳转到: \\accessDenied " , PrincalUtil.getPrincipal());
                    redirectStrategy.sendRedirect(request, response, "/accessDenied");
                }
            }
        };
    }
    
    
}
