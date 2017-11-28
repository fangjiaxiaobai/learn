package com.fxb.rbac0.services;

import com.fxb.rbac0.dao.UserDao;
import com.fxb.rbac0.entity.Role;
import com.fxb.rbac0.entity.User;
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

/**
 * @author fangxiaobai
 * @date 2017/11/20 18:04.
 * @description UserDetailService
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
        User user = userDao.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),
                true,true,true,true,getAuthorities(user));
    }
    
    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        if(null==user){
            return null;
        }
        ArrayList <GrantedAuthority> grantedAuthorities = new ArrayList <>();
        for(Role role : user.getRoles()) {
            logger.info("用户[{}] has permission : "+role.getRole(),user.getUsername());
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));
        }
        return grantedAuthorities;
    }
}
