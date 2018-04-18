package com.fxb.security.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 *  认证方式:
 *     认证方式可以有手机号+密码，微信号+密码(扫一扫),用户名密码。
 *
 *
 */
public interface AuthenticationProvider {

    /**
     * 尝试对Authentication进行认证
     */
    Authentication authenticate(Authentication authentication)
            throws AuthenticationException;

    /**
     * 是否支持该认证方式
     */
    boolean supports(Class<?> authentication);
}
