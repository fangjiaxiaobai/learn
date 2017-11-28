package com.fxb.rbac0.controller;

import com.fxb.rbac0.entity.User;
import com.fxb.rbac0.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/22 16:39.
 * @description UserController
 */
@RequestMapping("/user/")
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = {"/","list"},method = RequestMethod.GET)
    private String list(Model model, User user){
        List<User> users = this.userService.findAll(user);
        model.addAttribute("users",users);
        return "user/userList";
    }
    
    @RequestMapping(value = "form",method = RequestMethod.GET)
    private String form(Model model,User user){
        model.addAttribute("user",user);
        return "listForm";
    }
    
    @RequestMapping(value = "save")
    private String save(RedirectAttributes redirectAttributes, User user){
        this.userService.save(user);
        redirectAttributes.addAttribute("message","用户"+user.getUsername()+"添加成功");
        return "redirect:/user/list";
    }
    
    @RequestMapping(value = "delete")
    private String delete(RedirectAttributes redirectAttributes,User user){
        this.userService.delete(user);
        redirectAttributes.addAttribute("message","成功删除用户["+user.getUsername()+"]");
        return "redirect:/user/delete";
    }
}
