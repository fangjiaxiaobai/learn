package com.fxb.security.controller;

import com.fxb.security.entity.User;
import com.fxb.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/12 17:08.
 * @description UserController
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    
    @RequestMapping(value = {"/list","/"})
    public String list(Model model,User user){
        List<User> users = this.userService.findAll(user);
        model.addAttribute("users",users);
        model.addAttribute("loginUser",getPrincipal());
        return "user/userlist";
    }
    
    
    @RequestMapping("/newUser")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        model.addAttribute("edit","false");
        model.addAttribute("loggedUser",getPrincipal());
        return "user/newUser";
    }
    
    @RequestMapping(value = "/save")
    public String save(Model model,User user){
        this.userService.save(user);
        return "redirect:user/list?repage";
    }
    
    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = { "/edit-user-{id}" })
    public String editUser(@PathVariable String id, ModelMap model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "user/newUser";
    }
    
    /**
     * This method will delete an user by it's id value.
     */
    @RequestMapping(value = { "/delete-user-{id}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String id) {
        userService.deleteById(id);
        return "redirect:user/list";
    }
    
    
    /**
     * This method returns the principal[user-name] of logged-in user.
     * @return principal[user-name] of logged-in user
     */
    public String getPrincipal() {
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }else{
            username = principal.toString();
        }
        return username;
    }
    
   
}
