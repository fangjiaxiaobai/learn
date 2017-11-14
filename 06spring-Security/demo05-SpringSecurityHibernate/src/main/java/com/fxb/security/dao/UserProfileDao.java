package com.fxb.security.dao;

import com.fxb.security.dao.AbstractDao;
import com.fxb.security.entity.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/9 20:41.
 * @description UserProfileDao
 */
@Repository
public class UserProfileDao extends AbstractDao<String,UserProfile> {
    
    public List<UserProfile> findAll() {
        return this.findAll();
    }
    
}
