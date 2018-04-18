package com.fxb.security.core.userdetails;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 从数据库中读取数据的核心接口。
 */
public interface UserDetailsService {
    // ~ Methods
    // ========================================================================================================



    /**
     * 根据用户名读取 用户信息
     */
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
