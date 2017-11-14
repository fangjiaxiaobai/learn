package com.fxb.demo1;

import redis.clients.jedis.Jedis;

/**
 * @author fangxiaobai on 2017/10/20 14:39.
 * @description
 */
public class demo3_RedisListJava {
    
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        
        jedis.lpush("fxb2","fangxiaobai","wangsu","fanghengyu","chengsiyan");
    
        System.out.println(jedis.get("fxb"));
        System.out.println(jedis.lrange("fxb2",0,3));
    }
    
    
}
