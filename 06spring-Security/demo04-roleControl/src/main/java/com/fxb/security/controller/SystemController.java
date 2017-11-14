package com.fxb.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fangxiaobai
 * @date 2017/11/8 19:19.
 * @description SystemController
 */
@Controller
public class SystemController {
    
    @RequestMapping(value = {"/","/home"},method = RequestMethod.GET)
    public String homePage(Model model){
        model.addAttribute("user",getPrincipal());
        return "welcome";
    }
    
    @RequestMapping("admin")
    public String adminPage(Model model){
        model.addAttribute("user",getPrincipal());
        return "admin";
    }
    
    @RequestMapping("dba")
    public String dbaPage(Model model){
        model.addAttribute("user",getPrincipal());
        return "dba";
    }
    
    @RequestMapping("/accessDenied")
    public String accessDeniedPage(Model model){
        model.addAttribute("user",getPrincipal());
        return "accessDenied";
    }
    
    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }
    
    
    @RequestMapping("logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null) {
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
        return "redirect:/login?logout";
    }
    
    private Object getPrincipal() {
        String username = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }else{
            username = principal.toString();
        }
        return username;
    }
    
}
