package com.fxb.redisLearn;

import com.fxb.redisLearn.dao.UserDao;
import com.fxb.redisLearn.entity.User;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {

    
    private ApplicationContext applicationContext;
    private UserDao userDao;
    
    @Before
    public void before(){
        applicationContext = new ClassPathXmlApplicationContext("spring-redis.xml");
        userDao = (UserDao) applicationContext.getBean("userDao");
    }
    
    @org.junit.Test
    public void TestSet(){
        
        String id = "1";
        String username = "王粟" ;
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        userDao.set(user);
        User user1 = userDao.get(id);
        System.out.println(user1);
    
        userDao.del(id);
        user1 = userDao.get(id);
        System.out.println(user1);
        
        
    }
}
