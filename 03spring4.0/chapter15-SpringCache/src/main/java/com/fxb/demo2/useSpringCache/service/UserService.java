package com.fxb.demo2.useSpringCache.service;

import com.fxb.demo2.useSpringCache.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author wangxiyue on 2017/10/9 15:59.
 * @description
 */
@Service
public class UserService {

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Cacheable(cacheNames = "users")
    public User getUserById(String userId){
        return getFromDB(userId);
    }
    
    private User getFromDB(String userId) {
        //假装 从数据库中查询出来
        System.out.println("get from db..."+userId);
        User user= new User();
        user.setId(userId);
        user.setName("wangsu"+ new Random().nextInt()%10);
        user.setAge(23);
        return user;
    }
    
    /**
     * 重置缓存
     */
    @CacheEvict(value = "users",allEntries = true)
    public void reload(){
        System.out.println("delete all user from db");
    }
    
    
}