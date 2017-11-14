package com.fxb.security.config;

import com.fxb.security.entity.UserProfile;
import com.fxb.security.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author fangxiaobai
 * @date 2017/11/9 21:21.
 * @description RoleToUSserProfileConverter
 */
@Component
public class RoleToUSserProfileConverter implements Converter<Object,UserProfile> {
    
    @Autowired
    UserProfileService userProfileService;
    
    @Override
    public UserProfile convert(Object o) {
        UserProfile userProfile = userProfileService.findById((String) o);
        return userProfile;
    }
    
    
}
