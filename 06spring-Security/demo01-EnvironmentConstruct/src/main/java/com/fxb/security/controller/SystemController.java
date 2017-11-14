package com.fxb.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author fangxiaobai
 * @date 2017/11/7 12:55.
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
    
}
