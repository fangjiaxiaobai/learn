package com.fxb.security.core.userdetails;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * Provides core user information.
 *  封装了用户信息 的实体--用户详情。
 */
public interface UserDetails extends Serializable {
    // ~ Methods
    // ========================================================================================================

    /**
     * 返回授予用户的权限
     */
    Collection<? extends GrantedAuthority> getAuthorities();

    String getPassword();

    String getUsername();

    /**
     * 标识一个用户登录是否过期
     */
    boolean isAccountNonExpired();

    /**
     * 标识一个用户是否被锁定
     */
    boolean isAccountNonLocked();

    /**
     * 用户的密码已经过期
     */
    boolean isCredentialsNonExpired();

    /**
     * 标识用户是否可用
     */
    boolean isEnabled();
}
