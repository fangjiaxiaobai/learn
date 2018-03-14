package demo3_cglibProxy;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/5
 * 1.需要引入cglib的jar文件,但是Spring的核心包中已经包括了Cglib功能,所以直接引入pring-core-3.2.5.jar即可.
2.引入功能包后,就可以在内存中动态构建子类
3.代理的类不能为final,否则报错
4.目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方
 */
public class ProxyFactory implements MethodInterceptor{
    private Object target;
    
    public ProxyFactory(Object target){
        this.target = target;
    }
    
    public Object getProxyInstance(){
        Enhancer en = new Enhancer();
        en.setSuperclass(UserDao.class);
        en.setCallback(this);
        return en.create();
    }
    
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务");
        Object returnValue =method.invoke(target, objects);
        System.out.println("提交事务");
        return returnValue;
    }
}
