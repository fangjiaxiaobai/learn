package com.fxb.demo1.useCache.service;

import com.fxb.demo1.useCache.cache.CacheManager;
import com.fxb.demo1.useCache.entity.User;

import java.util.Random;

/**
 * @author wangxiyue on 2017/10/9 15:59.
 * @description
 */
public class UserService {
    private CacheManager<User> cacheManager;
    public UserService(){
        //构造一个缓存管理器
        cacheManager = new CacheManager <User>();
    }
    
    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    public User getUserById(String userId){
        User result = cacheManager.getValue(userId);
        if(null!=result){
            System.out.println("get from cache......"+userId);
            return result;
        }
        
        result = getFromDB(userId);
        if(null!=result){
            // 更新缓存
            cacheManager.addOrUpdateCache(userId,result);
        }
        return result;
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
    public void reload(){
        cacheManager.evictCache();
    }
    
    
}
