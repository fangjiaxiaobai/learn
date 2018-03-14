package demo3_cglibProxy;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/5
 */
public class DemoTest {
    
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        UserDao proxy=(UserDao) new ProxyFactory(userDao).getProxyInstance();
        proxy.save();
    }
}
