package demo2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 方小白 on 2017/9/29 12:02.
 * @description
 *
 *      增强的类越多，就需要越大的方法区来保证动态生成的Class可以加载入内存。
 */
public class JavaMethodAreaOOM {
    
    public static void main(String[] args) {
        
        while(true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            enhancer.create();
    
        }
    }
    
    static class OOMObject{
        
    }
}
