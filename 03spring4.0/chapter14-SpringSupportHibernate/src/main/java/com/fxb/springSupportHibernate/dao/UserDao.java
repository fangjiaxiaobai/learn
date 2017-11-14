package com.fxb.springSupportHibernate.dao;

import com.fxb.springSupportHibernate.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 方小白 on 2017/9/29 17:08.
 * @description
 */

@Repository
public class UserDao extends HibernateDaoSupport{
    
    
    @Autowired
    public void setMyHibernateTemplate(HibernateTemplate hibernateTemplate){
        this.setHibernateTemplate(hibernateTemplate);
    }
    
    public void addUser(User user){
        getHibernateTemplate().save(user);
    }
  
    public void updateUser(User user){
        getHibernateTemplate().update(user);
    }
    
    public User findUser(User user){
        return    getHibernateTemplate().get(User.class,user.getId());
    }
    
    public void deleteUser(User user){
        getHibernateTemplate().delete(user);
    }
    
    public List<User> findAllUSer(){
        return (List<User>)getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(User.class));
    }
    
    
}
