package com.fxb.demo1;

import redis.clients.jedis.Jedis;

/**
 * @author fangxiaobai on 2017/10/20 14:34.
 * @description
 */
public class demo2_RedisStringJava {
    
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        jedis.set("fxb","www.fxb.com");
        System.out.println(jedis.get("fxb"));
    }
    
    
}
