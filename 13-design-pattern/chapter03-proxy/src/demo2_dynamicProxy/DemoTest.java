package demo2_dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/5
 */
public class DemoTest {
    
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        IUserDao proxy=(IUserDao)new UserDaoProxy(userDao).getProxyInstance();
        proxy.save();
    
    
        Object o=Proxy.newProxyInstance(UserDao.class.getClassLoader(), userDao.getClass().getInterfaces(), (obj, method, argrs) -> {
            System.out.println("start........");
            Object returnValue=method.invoke(obj, argrs);
            System.out.println("end........");
            return returnValue;
        });
        
    }
    
}
