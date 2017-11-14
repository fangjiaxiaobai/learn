package com.fxb.classLoader;

/**
 * @author wangxiyue on 2017/9/21 20:29.
 * @description
 */
public class ClassLoaderTest {
    
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
    
        System.out.println("current loader:" + loader);
        System.out.println("parent loader:"+loader.getParent());
        // 跟加载器在java中访问不到，返回null
        System.out.println("grandparent loader:"+loader.getParent().getParent());
        
        
        
    }
    
}
