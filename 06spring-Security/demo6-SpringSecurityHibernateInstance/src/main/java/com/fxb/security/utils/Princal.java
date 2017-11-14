package com.fxb.security.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author fangxiaobai
 * @date 2017/11/12 17:33.
 * @description Princal
 */
public class Princal {
    
    /**
     * This method returns the principal[user-name] of logged-in user.
     *
     * @return principal[user-name] of logged-in user
     */
    public static String getPrincipal() {
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
    
}
