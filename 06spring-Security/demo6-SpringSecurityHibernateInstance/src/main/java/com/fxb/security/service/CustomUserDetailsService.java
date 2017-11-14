package com.fxb.security.service;

import com.fxb.security.entity.Role;
import com.fxb.security.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/12 15:49.
 * @description UserDetailsService
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    
    @Autowired
    private UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        logger.info("User : {}",user);
        if(null==user) {
            logger.info("not found user：{}",username);
            throw new UsernameNotFoundException(username+" not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),true,true,true,true,getGrantedAuthorities(user));
    }
    
    private List<? extends GrantedAuthority> getGrantedAuthorities(User user) {
        ArrayList <GrantedAuthority> authorities = new ArrayList <GrantedAuthority>();
        for(Role role : user.getRoles()) {
            logger.info("User-Role:{}",role);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getType()));
        }
        logger.info("authorities:{}",authorities);
        return authorities;
    }
}
