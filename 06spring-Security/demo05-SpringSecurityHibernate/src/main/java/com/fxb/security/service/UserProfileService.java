package com.fxb.security.service;

import com.fxb.security.dao.UserProfileDao;
import com.fxb.security.entity.UserProfile;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/9 20:41.
 * @description UserProfileService
 */
@Service
public class UserProfileService {
    
    private UserProfileDao userProfileDao;
    
    public List<UserProfile> findAll() {
        return this.userProfileDao.findAll();
    }
    
    public UserProfile findById(String o) {
        return this.userProfileDao.getByKey(o);
    }
}
