package com.fxb.security.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author fangxiaobai
 * @date 2017/11/12 16:28.
 * @description SecurityInitializer
 *
 *  将 Spring Security 注册到 servlet容器中。
 *      相当于在web.xml中，
 *      springSecurityChain
 *
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}
