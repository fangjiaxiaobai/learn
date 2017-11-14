package com.fxb.security.controller;

import com.fxb.security.service.UserProfileService;
import com.fxb.security.entity.User;
import com.fxb.security.entity.UserProfile;
import com.fxb.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/9 20:34.
 * @description UserController
 */
@Controller
public class UserController {
    
    @Autowired
   private UserService userService;
    private UserProfileService userProfileService;
    
    @RequestMapping(value = "/newUser",method = RequestMethod.GET)
    public String newRegistration(ModelMap modelMap){
        User user = new User();
        modelMap.addAttribute("user",user);
        return "newUser";
    }
    
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveRegistration(@Validated User user, BindingResult result, ModelMap modelMap){
        if(result.hasErrors()){
            System.out.println("there are errors");
            return "newUser";
        }
        userService.save(user);
        
        modelMap.addAttribute("success",user.getUsername()+"has been registered successfully!");
        return "registrationsuccess";
    }
    
    public List<UserProfile> initializeProfiles(){
        return userProfileService.findAll();
    }
    
    
    
}
