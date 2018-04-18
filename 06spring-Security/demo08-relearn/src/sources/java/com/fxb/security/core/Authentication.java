

package com.fxb.security.core;

import java.io.Serializable;
import java.security.Principal;
import java.util.Collection;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *  是SpringSecurity中最高级别的身份/认证的抽象。
 */
public interface Authentication extends Principal, Serializable {


    /**
     *  作用： 获取权限信息列表（代表权限的一系列的字符串）
     *
     * 通过设置AuthenticationManager(认证管理员)来表明当前登录人是否授权。
     * 除非设置了一个可信的AuthenticationManager，否则不能认为返回的这些信息是有效的。
     * 其实现类应确保返回的集合数组 不影响认证对象的状态，或者使用不可变的实例。
     * @return
     */
    Collection<? extends GrantedAuthority> getAuthorities();


    /**
     * 获取证书。
     * 获取密码
     * @return
     */
    Object getCredentials();


    /**
     * 获取 细节信息
     * 细节信息，web应用中的实现接口通常为 WebAuthenticationDetails，它记录了访问者的ip地址和sessionId的值。
     * @return
     */
    Object getDetails();

    /**
     * 获取用户信息(获取主要信息)
     * @return
     */
    Object getPrincipal();


    /**
     *  是否已认证
     * @return
     */
    boolean isAuthenticated();


    /**
     * 设置认证状态
     * @param isAuthenticated
     * @throws IllegalArgumentException
     */
    void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException;
}
