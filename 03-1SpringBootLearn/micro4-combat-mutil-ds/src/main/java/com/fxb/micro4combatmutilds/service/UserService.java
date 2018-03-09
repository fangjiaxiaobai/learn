package com.fxb.micro4combatmutilds.service;

import com.fxb.micro4combatmutilds.config.annotation.TargetDataSource;
import com.fxb.micro4combatmutilds.mapper.UserMapper;
import com.fxb.micro4combatmutilds.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Target;
import java.util.List;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
@Service
public class UserService {
    
    /**
     *
     */
    @Autowired
    private UserMapper userMapper;
    
    @TargetDataSource("ds1")
    public List<User> findAllUser() {
       return this.userMapper.selectUser();
    }
    
    @TargetDataSource("ds2")
    public List<User> findAllUser2(){
        return this.userMapper.selectUser();
    }
}
