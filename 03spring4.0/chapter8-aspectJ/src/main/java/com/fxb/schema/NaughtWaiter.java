package com.fxb.schema;

/**
 * @author wangxiyue on 2017/9/28 15:16.
 * @description
 */
public class NaughtWaiter implements Waiter{
    
    public void greetTo(String name){
        System.out.println(" naughtWaiter   greetTo ...." +name);
    }
}
