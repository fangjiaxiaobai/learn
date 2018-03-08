package demo1_staticProxy;

import demo1_staticProxy.IUserDao;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/5
 */
public class UserDaoProxy {
    
    private IUserDao userDao;
    
    public UserDaoProxy(IUserDao userDao) {
        this.userDao=userDao;
    }
    
    public void save(){
        System.out.println("开始事务");
        userDao.save();
        System.out.println("结束事务");
    }
    
    
}
