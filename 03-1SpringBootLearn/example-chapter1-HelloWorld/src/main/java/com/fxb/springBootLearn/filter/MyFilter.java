package com.fxb.springBootLearn.filter;

import com.sun.javafx.binding.StringFormatter;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.logging.Logger;

/**
 * @author 方小白 on 2017/9/15 11:50.
 * @description
 */
public class MyFilter implements Filter {
    
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(MyFilter.class);
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("----------- fxb 自定义过滤器 init。。。。。");
        
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("fxb's filter : url is "+ ((HttpServletRequest) request).getRequestURL());
        chain.doFilter(request, response);
    }
    
    @Override
    public void destroy() {
        logger.info("----------- fxb 自定义过滤器 destroy。。。。。");
    }
}
