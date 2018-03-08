package demo1_staticProxy;

import demo1_staticProxy.IUserDao;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/5
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("this save method in demo1_staticProxy.UserDao");
    }
}
