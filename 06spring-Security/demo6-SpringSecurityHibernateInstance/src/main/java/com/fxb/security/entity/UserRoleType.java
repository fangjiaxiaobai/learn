package com.fxb.security.entity;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import java.io.Serializable;

/**
 * @author fangxiaobai
 * @date 2017/11/12 16:05.
 * @description UserRoleType
 */
public enum  UserRoleType implements Serializable {
    
    USER("USER"),DBA("DBA"),ADMIN("ADMIN");
    
    String userRoleType;
    
    UserRoleType(String userRoleType) {
        this.userRoleType = userRoleType;
    }
    
    public String getUserRoleType(){
        return userRoleType;
    }
    
}
