package com.fxb.security.config;

import com.fxb.security.utils.Princal;
import org.hibernate.boot.registry.selector.StrategyRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author fangxiaobai
 * @date 2017/11/12 13:39.
 * @description SecurityConfiguration
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    private static final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);
    
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PersistentTokenRepository tokenRepostory;
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    
    /**
     * / , /list : 供所有用户访问；
     * /newuser , /delete-user-* : 只供管理员(Admin)用户访问；
     * /edit-user-* : 供 Admin or DBA 用户访问
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("配置访问规则");
        http.authorizeRequests()
                .antMatchers("/loginPage").permitAll()
                .antMatchers("/doLogin").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/").access("hasRole('USER')")
                .antMatchers("/user/", "/user/list").access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
                .antMatchers("/user/newuser/**", "/user/delete-user-*").access("hasRole('ADMIN')")
                .antMatchers("/edit-user-**").access("hasRole('ADMIN') or hasRole('DBA')")
                .and()
                .formLogin().loginPage("/loginPage").successForwardUrl("/index")
                .loginProcessingUrl("/doLogin").successHandler(getAuthenticationSuccessHandler())
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutUrl("logout").logoutSuccessUrl("/loginPage?logout")
                .and()
                .rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepostory).tokenValiditySeconds(86400)
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied")
                .and()
                .csrf();
//
//        super.configure(http);
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    /**
     * Spring Security带有两个PersistentTokenRepository的实现： JdbcTokenRepositoryImpl 和 InMemoryTokenRepositoryImpl.
     *
     * @return
     */
    
    @Bean
    public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
        PersistentTokenBasedRememberMeServices services =
                new PersistentTokenBasedRememberMeServices("remember-me", userDetailsService, tokenRepostory);
        return services;
    }
    
    @Bean
    AuthenticationTrustResolver authenticationTrustResolver() {
        return new AuthenticationTrustResolverImpl();
    }
    
    /**
     * 跳转成功后自定义 url
     *
     * @return
     */
    @Bean
    public SimpleUrlAuthenticationSuccessHandler getAuthenticationTrustResolver() {
        return new SimpleUrlAuthenticationSuccessHandler() {
            @Override
            protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                super.handle(request, response, authentication);
            }
        };
    }
    
    @Bean
    public AuthenticationSuccessHandler getAuthenticationSuccessHandler() {
        
        return new SimpleUrlAuthenticationSuccessHandler() {
            RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
            private Logger logger = LoggerFactory.getLogger(SimpleUrlAuthenticationSuccessHandler.class);
            @Override
            protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                Collection <? extends GrantedAuthority> authorities = authentication.getAuthorities();
                ArrayList <String> roles = new ArrayList <>();
                for(GrantedAuthority authority : authorities) {
                    roles.add(authority.getAuthority());
                }
                logger.info("用户[{}]拥有权限:" + roles, Princal.getPrincipal());
                if(roles != null) {
                    logger.info("用户[{}]跳转到: \\index " , Princal.getPrincipal());
                    redirectStrategy.sendRedirect(request, response, "/index");
                } else {
                    logger.info("用户[{}]跳转到: \\accessDenied " , Princal.getPrincipal());
                    redirectStrategy.sendRedirect(request, response, "/accessDenied");
                }
            }
        };
    }
}
