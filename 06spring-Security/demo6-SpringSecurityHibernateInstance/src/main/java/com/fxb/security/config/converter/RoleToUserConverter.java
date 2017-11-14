package com.fxb.security.config.converter;

import com.fxb.security.entity.Role;
import com.fxb.security.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author fangxiaobai
 * @date 2017/11/12 16:51.
 * @description RoleToUserController
 */
@Component
public class RoleToUserConverter implements Converter<Object,Role> {
    
    static final Logger logger = LoggerFactory.getLogger(RoleToUserConverter.class);
    
    @Autowired
    private RoleService roleService;
    
    @Override
    public Role convert(Object o) {
        String id = (String) o;
        Role role = roleService.findById(id);
        
        return null;
    }
}
