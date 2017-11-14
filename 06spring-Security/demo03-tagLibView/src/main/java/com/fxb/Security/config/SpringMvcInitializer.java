package com.fxb.Security.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author fangxiaobai
 * @date 2017/11/8 11:09.
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
