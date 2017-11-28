package com.fxb.rbac0.controller;

import com.fxb.rbac0.common.utils.PrincalUtil;
import com.fxb.rbac0.entity.User;
import com.fxb.rbac0.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author fangxiaobai
 * @date 2017/11/21 18:16.
 * @description SystemController
 *
 *      应用的初始控制 controller
 *          登录 ，退出等。
 *
 */
@Controller
public class SystemController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/index")
    public String index(Model model){
        
        String username = PrincalUtil.getPrincipal();
        if(username==null || "anonymousUser".equals(username)){
            return "login";
        }
        User user = userService.findByUsername(username);
        model.addAttribute("user",user);
        model.addAttribute("menu",user.getRoles());
        return "sys/index";
    }
    
    @RequestMapping("/welcome")
    public String welcome(){
        return "sys/welcome";
    }
    
    
}
