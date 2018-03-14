package demo2_dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/5
 */
public class UserDaoProxy {
    
    private Object target;
    
    public UserDaoProxy(Object target){
        this.target = target;
    }
    
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            (Object proxy,Method method,Object[] args)->{
                System.out.println("开始事务2");
                Object returnValue = method.invoke(target,args);
                return  returnValue;
            });
    }
    
    
}
