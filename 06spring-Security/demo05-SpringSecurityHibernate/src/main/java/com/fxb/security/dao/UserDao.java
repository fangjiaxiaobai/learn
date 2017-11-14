package com.fxb.security.dao;

import com.fxb.security.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author fangxiaobai
 * @date 2017/11/8 21:41.
 * @description UserDao
 */
@Repository
public class UserDao extends AbstractDao<String,User>{
    
    public User findById(String id){
        return getByKey(id);
    }
    
    public User findByName(String username){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username",username));
        return (User) criteria.uniqueResult();
        
    }
    
    
}
