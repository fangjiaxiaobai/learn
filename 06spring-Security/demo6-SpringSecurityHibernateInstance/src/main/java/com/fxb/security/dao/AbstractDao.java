package com.fxb.security.dao;


import com.fxb.security.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * @author fangxiaobai
 * @date 2017/11/12 15:23.
 * @description AbstractDao
 */
public class AbstractDao<PK extends Serializable, T> {
    
    private final Class<T> persistentClass;
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @SuppressWarnings("unchecked")
    public T getByKey(PK key){
        return getSession().get(persistentClass,key);
    }
    
    public void persist(T entity){
        getSession().persist(entity);
    }
    
    public void update(T entity){
        getSession().update(entity);
    }
    
    public void delete(T entity){
        getSession().delete(entity);
    }
    
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
    
    
    public void save(User user) {
        getSession().save(user);
    }
}
