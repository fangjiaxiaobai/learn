package com.fxb.security.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author fangxiaobai
 * @date 2017/11/7 19:31.
 * @description SpringMVCInitializer
 */
public class SpringMVCInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    
    @Override
    protected Class <?>[] getRootConfigClasses() {
        return new Class <?>[]{SpringMVCConfig.class};
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
