package com.fxb.learn.chapter7zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/27
 */
public class AccessFilter extends ZuulFilter{
    
    private Logger logger = LoggerFactory.getLogger("accessFilter");
    
    /**
     * 过滤器的类型。它决定过滤器在请求的哪个生命周期里执行。
     * pre: 掉包在请求被路由之前执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }
    
    /**
     * 过滤器执行的顺序，
     * 当请求在一个阶段中存在多个过滤器时，需要根据该方法的返回值进行一次执行。
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }
    
    /**
     * 判断过滤器是否执行。
     * 也可以利用该函数指定过滤器的执行范围。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
    
    /**
     * 过滤的具体逻辑。
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());
        String accessToken = request.getParameter("accessToken");
        if (null==accessToken) {
            logger.warn("access token is empty!");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("这里可以对响应体进行编辑等。。。。");
            ctx.setResponseBody("here , can edit the response etc.");
            return null;
        }
        logger.info("access token is ok!");
        return null;
    }
}
