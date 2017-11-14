package com.fxb.security.entity;

/**
 * @author fangxiaobai
 * @date 2017/11/8 21:29.
 * @description UserProfileType
 */
public enum UserProfileType {
    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");
    
    String userProfileType;
    
    private UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }
    
    public String getUserProfileType(){
        return userProfileType;
    }
}
