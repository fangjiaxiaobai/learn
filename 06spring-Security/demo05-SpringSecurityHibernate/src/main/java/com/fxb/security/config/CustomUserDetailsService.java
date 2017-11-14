package com.fxb.security.config;

import com.fxb.security.entity.UserProfile;
import com.fxb.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author fangxiaobai
 * @date 2017/11/8 21:12.
 * @description UserDetailsService
 */
@Service("customUserDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.fxb.security.entity.User user = userService.findByUsename(username);
        System.out.println("user:"+user);
        if(null==user) {
            System.out.println("user not found!");
            throw new UsernameNotFoundException("username not found");
        }
        return new User(user.getUsername(),user.getPassword(),"Active".equals(user.getState()),true,true,true,getGrantedAuthorities(user));
    }
    
    private Collection<? extends GrantedAuthority> getGrantedAuthorities(com.fxb.security.entity.User user) {
        ArrayList <GrantedAuthority> grantedAuthorities = new ArrayList <GrantedAuthority>();
        for(UserProfile userProfile : user.getUserProfiles()) {
            System.out.println("userProfile:"+userProfile);
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
        }
        System.out.println("authorities:"+grantedAuthorities);
        return grantedAuthorities;
    }
}
