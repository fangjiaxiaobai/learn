package com.fxb.security.controller;

import com.fxb.security.utils.Princal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fangxiaobai
 * @date 2017/11/12 17:07.
 * @description SystemController
 */
@Controller
public class SystemController {
    @Autowired
    private PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
    @Autowired
    private AuthenticationTrustResolver authenticationTrustResolver;
    
    @RequestMapping(value = "/accessDenied")
    private String accessDeniedPage(ModelMap model){
        model.addAttribute("loggerUser", Princal.getPrincipal());
        return "accessDenied";
    }
    
    /**
     *  跳转到主页。
     * @param model
     * @return
     */
    @RequestMapping("index")
    public String index(ModelMap model){
        model.addAttribute("loginUser",Princal.getPrincipal());
        return "welcome";
    }
    
    /**
     * This method handles login GET requests.
     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
     */
    @RequestMapping(value = "/loginPage")
    public String loginPage() {
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
        } else {
            return "redirect:/list";
        }
    }
    
    
    /**
     * This method handles logout requests.
     * Toggle the handlers if you are RememberMe functionality is useless in your app.
     */
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/loginPage?logout";
    }
    
    /**
     * This method returns true if users is already authenticated [logged-in], else false.
     */
    private boolean isCurrentAuthenticationAnonymous(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
    
}
