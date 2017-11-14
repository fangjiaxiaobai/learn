package com.fxb.security.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author fangxiaobai
 * @date 2017/11/12 17:05.
 * @description SpringInitializer 整个应用的总配置类
 *      AbstractAnnotationConfigDispatcherServletInitializer：负责配置DispatcherServlet，初始化SpringMvc容器和Spring容器。
 *
 */

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    
    /**
     *  获取Spring容器的配置文件，
     * @return
     */
    @Override
    protected Class <?>[] getRootConfigClasses() {
        return new Class <?>[]{SpringConfiguration.class};
    }
    
    /**
     * 获取SpringMvc应用容器的配置
     * @return
     */
    @Override
    protected Class <?>[] getServletConfigClasses() {
        return new Class<?>[]{SpringMvcConfiguration.class};
    }
    
    /**
     * 负责指定需要由DispatcherServlet映射的路径。
     *
     * @return “/” 由DispatcherServlet处理所有向该应用发起的请求。
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("-----------------------------***************************");
        super.onStartup(servletContext);
    }
}
