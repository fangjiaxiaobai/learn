package com.fxb.relearn.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * demo08-relearn
 *
 * @author fangjiaxiaobai@163.com
 * @date 2018-04-12
 */
public class UserDetialsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        HashSet<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(()-> {
                return "ROLE_ADMIN";
        });

        return new User("admin","admin",grantedAuthorities);
    }
}
