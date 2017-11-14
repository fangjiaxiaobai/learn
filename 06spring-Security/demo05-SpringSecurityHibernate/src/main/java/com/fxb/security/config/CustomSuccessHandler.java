package com.fxb.security.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author fangxiaobai
 * @date 2017/11/8 14:18.
 * @description CustomSuccessHandler
 */
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
    
//    重定向策略
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(authentication);
        if(response.isCommitted()){
            System.out.println("can't redirect,because response had committed");
            return;
        }
        redirectStrategy.sendRedirect(request,response,targetUrl);
    }
    
    /**
     * This method extracts the roles of currently logged-in user and returns
     * appropriate URL according to his/her role.
     *
     * @param authentication
     * @return
     */
    private String determineTargetUrl(Authentication authentication) {
        String url = "";
        Collection <? extends GrantedAuthority> authorities = authentication.getAuthorities();
        ArrayList roles = new ArrayList();
    
        for(GrantedAuthority authority : authorities) {
            roles.add(authority.getAuthority());
        }
        
        if(isRole(roles,"ROLE_DBA")){
            url = "/dba";
        }else if(isRole(roles,"ROLE_ADMIN")){
            url = "/admin";
        }else if(isRole(roles,"ROLE_USER")){
            url = "/home";
        }else{
            url = "/accessDenied";
        }
        return url;
    }
    
    private Boolean isRole(ArrayList roles,String role){
        if(roles!=null&&role!=null){
            if(roles.contains(role)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
    
    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
}
