package com.fxb.demo1;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * @author fangxiaobai on 2017/10/20 14:45.
 * @description
 */
public class demo4_RedisKeyJava {
    
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("connect success");
    
        Set<String> keys = jedis.keys("*");
        Iterator<String> it =  keys.iterator();
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }
    
}
