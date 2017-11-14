package com.fxb.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fangxiaobai
 * @date 2017/11/7 20:51.
 * @description SystemController
 */
@Controller
public class SystemController {
    
    @RequestMapping(value = {"/","/welcome**"},method = RequestMethod.GET)
    public ModelAndView welcomePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title","Spring Security Learn");
        modelAndView.addObject("message","This is welcome Page！");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
    
    @RequestMapping(value="/admin**",method = RequestMethod.GET)
    public String adminPage(Model model){
        model.addAttribute("title","Spring Security Learn");
        model.addAttribute("message","This is Admin Page!");
        return "admin";
    }
    
    @RequestMapping("/login")
    public String login(Model model, @RequestParam(value = "error",required = false) String error
            ,@RequestParam(value = "logout" ,required = false) String logout){
        if(null!=error){
            model.addAttribute("error","Invalid username and password");
        }
        if(null!=logout){
            model.addAttribute("message","You have been logged out successfully.");
        }
        return "login";
    }
    
    @RequestMapping("logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //如果用户在认证之后使用 SecurityContextHolder.getContext().getAuthentication() 。
        //如果是这样，那么我们调用 SecurityContextLogoutHandler().logout(request, response, auth) 注销用户
        if(null!=authentication){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
        
        return "redirect:/login?logout";
    }
    
    
    @RequestMapping("Access_Denied")
    public String accessDenied(Model model){
        model.addAttribute("title","Denied");
        model.addAttribute("message","you don't have permission to view it");
        return "hello";
    }
    
    
}
