package com.fxb.rbac0;

import com.fxb.rbac0.config.SpringConfiguration;
import com.fxb.rbac0.config.SpringMVCConfiguration;
import org.springframework.lang.Nullable;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @CLASSNAME: ApplicationInitializer
 * @AUTHOR: fangjiaxiaobai
 * @DATETIME: 2017-11-15 23:42
 * @DESCRIPTiONS:
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfiguration.class};
    }

    @Nullable
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("fangjiaxiaobai RBAC demo starting..............");
        super.onStartup(servletContext);
    }
}
