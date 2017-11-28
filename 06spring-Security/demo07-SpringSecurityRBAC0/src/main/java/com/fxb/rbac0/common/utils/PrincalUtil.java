package com.fxb.rbac0.common.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author fangxiaobai
 * @date 2017/11/21 17:31.
 * @description PrincalUtil
 */
public class PrincalUtil {
    /**
     * This method returns the principal[user-name] of logged-in user.
     *
     * @return principal[user-name] of logged-in user
     */
    public static String getPrincipal() {
        String username = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication==null){
            return username;
        }
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
}
