package com.fxb.security.conf;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author fangxiaobai
 * @date 2017/11/7 14:37.
 * @description SpringSecurityInitializer
 *
 *      创建一个AbstractSecurityWebApplicationInitializer的扩展类
 *
 */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer{
    /// doSomething
    
    
}
//    这等同于以下 Spring Security 中的 web.xml 文件，如下：
//
//<filter>
//<filter-name>springSecurityFilterChain</filter-name>
//<filter-class>org.springframework.web.filter.DelegatingFilterProxy
//</filter-class>
//</filter>
//
//<filter-mapping>
//<filter-name>springSecurityFilterChain</filter-name>
//<url-pattern>/*</url-pattern>
//	</filter-mapping>