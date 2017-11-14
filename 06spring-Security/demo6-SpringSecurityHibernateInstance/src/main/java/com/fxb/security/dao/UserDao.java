package com.fxb.security.dao;

import com.fxb.security.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/12 16:11.
 * @description UserDao
 */
@Repository
@Transactional
public class UserDao extends AbstractDao<String,User> {
    
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
    
    public User findByUsername(String username) {
        Criteria criteria = createEntityCriteria().add(Restrictions.eq("username", username));
        User user =  (User) criteria.uniqueResult();
        if(null!=user){
            Hibernate.initialize(user.getRoles());
        }
        return user;
    }
    
    public List<User> findAll(User user) {
        return createEntityCriteria().list();
    }
}
