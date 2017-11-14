package com.fxb.security.controller;

import com.fxb.security.entity.Role;
import com.fxb.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/12 17:28.
 * @description RoleController
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    
    @Autowired
    private RoleService roleService;
    
    /**
     * This method will provide UserProfile list to views
     */
    @ModelAttribute("roles")
    public List<Role> initializeProfiles() {
        return roleService.findAll();
    }
    
    
}
