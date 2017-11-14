package com.fxb.demo1;

import redis.clients.jedis.Jedis;

/**
 * @author fangxiaobai on 2017/10/20 14:29.
 * @description
 */
public class RedisJava {
    
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        System.out.println("服务正在运行:"+jedis.ping());
    }
    
}
