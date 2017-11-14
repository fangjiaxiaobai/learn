package com.fxb.security.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author fangxiaobai
 * @date 2017/11/7 20:35.
 * @description SpringMvcInitializer
 */
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    
    @Override
    protected Class <?>[] getRootConfigClasses() {
        return new Class <?>[]{SpringMvcConfig.class};
    }
    
    @Override
    protected Class <?>[] getServletConfigClasses() {
        return null;
    }
    
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
