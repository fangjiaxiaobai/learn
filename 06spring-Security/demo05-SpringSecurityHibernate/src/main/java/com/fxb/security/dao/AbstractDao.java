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
 * @date 2017/11/8 21:39.
 * @description AbstractDao
 */
public abstract class AbstractDao<PK extends Serializable,T> {
    private final Class<T> persistentClass;
    
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
    
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }
    
    public void persist(T entity) {
        getSession().persist(entity);
    }
    
    public void delete(T entity) {
        getSession().delete(entity);
    }
    
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
    
    public void save(User user) {
        this.getSession().save(persistentClass);
    }
}
