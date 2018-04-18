package com.fxb.security.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * 认证的接口，发起认证的出发点。
 * 认证管理
 *     对Authentication进行解析，并认证。
 *   其实现类有
 *      OAuth2AuthenticationManager
 *      ProviderManager
 *      AuthenticationManagerDelegator(in WebSecurityConfigurerAdapter)
 *      .....
 * 但是 AUthenticationManager一般不直接认证，例如其实现类ProviderManager中就维护了一个AuthenticationProvider的列表，存放多种认证方式。
 *  委托者设计模式的应用。
 *
 */
public interface AuthenticationManager {

    /**
     * 尝试验证Authentication，如果验证成功，
     *  就返回一个完全封装的Authentication对象。
     *      一般包含权限信息，身份信息，细节信息。密码一般会被移除。
     */
    Authentication authenticate(Authentication authentication)
            throws AuthenticationException;
}
