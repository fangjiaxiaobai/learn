package com.fxb.rbac0.dao;

import com.fxb.rbac0.common.annotation.MyBatisDao;
import com.fxb.rbac0.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/20 18:05.
 * @description UserDao
 */
@MyBatisDao
public interface UserDao {
    
    @Deprecated
    User loadUserByUsername(String username);
    
    /**
     * 根据用户名查找User
     * @param username 用户名(登录名)
     * @return
     */
    User findByUsername(String username);
    
    /**
     * 查询所有User
     * @param user
     * @return
     */
    List<User> findAll(User user);
    
    /**
     * 保存用户
     * @param user
     */
    void save(User user);
    
    /***
     *   根据user的id 删除用户。
     * @param user
     */
    void delete(User user);
}
