package com.fxb.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author wangxiyue on 2017/9/21 20:15.
 * @description
 */
public class ReflectTest {
        public static Car initByDefaultConst() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            Class <?> aClass = loader.loadClass("com.fxb.reflect.Car");
    
            Constructor constructor = aClass.getDeclaredConstructor(null);
            Car o = (Car)constructor.newInstance(null);
            return o;
        }
}
