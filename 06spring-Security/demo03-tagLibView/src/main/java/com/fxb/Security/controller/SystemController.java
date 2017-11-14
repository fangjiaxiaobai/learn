package com.fxb.Security.controller;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fangxiaobai
 * @date 2017/11/8 10:51.
 * @description SystemController
 *
 *      登录controller
 *
 *
 */
@Controller
public class SystemController {
    
    @RequestMapping(value = {"/","home"})
    public String homePage(Model model){
        model.addAttribute("user",getPrincipal());
        return "home";
    }
    
    @RequestMapping(value = "/Access_Denied")
    public String accessDenied(Model model){
        model.addAttribute("user",getPrincipal());
        return "accessDenied";
    }
    
    @RequestMapping(value = "/loginPage")
    public String loginPage(Model model,@RequestParam(value = "error",required = false) String error
            ,@RequestParam(value = "logout" ,required = false) String logout){
        if(null!=error){
            model.addAttribute("error","Invalid username and password");
        }
        if(null!=logout){
            model.addAttribute("message","You have been logged out successfully.");
        }
        return "login";
    }
    
    @RequestMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(null!=auth) {
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }
//         TODO : why login?logout
        return "redirect:/login?logout";
    }
    
    
    private String getPrincipal() {
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }else{
            username = principal.toString();
        }
        return username;
    }
    
}
