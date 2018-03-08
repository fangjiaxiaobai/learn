package com.fxb.micro3componentmybatis.service;

import com.fxb.micro3componentmybatis.mapper.UserMapper;
import com.fxb.micro3componentmybatis.model.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/8
 */
@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    public int addUser(User user) {
        return userMapper.insert(user);
    }
    
    public List<User> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return userMapper.selectAllUser();
    }
    

}
