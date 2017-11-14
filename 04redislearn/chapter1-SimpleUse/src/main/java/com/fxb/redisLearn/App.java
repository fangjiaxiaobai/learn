package com.fxb.redisLearn;

import com.fxb.redisLearn.pool.MyJedisPool;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * Hello world!
 *
 */
public class App {
    
    public static JedisPool pool;
    static{
        ResourceBundle bundle = ResourceBundle.getBundle("config");
        if(null==bundle){
            throw new IllegalArgumentException("config.properties is not found");
        }
        
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxActive(Integer.valueOf(bundle.getString("redis.pool.maxActive")));
        config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
        config.setMaxWait(Long.valueOf(bundle.getString("redis.pool.maxWait")));
        config.setTestOnBorrow(Boolean.valueOf(bundle
                .getString("redis.pool.testOnBorrow")));
        config.setTestOnReturn(Boolean.valueOf(bundle
                .getString("redis.pool.testOnReturn")));
        pool = new JedisPool(config,bundle.getString("redis.ip"),Integer.valueOf(bundle.getString("redis.port")));
    }
    
    public static void main( String[] args )
    {
        // 从池中获取对象
        Jedis jedis = pool.getResource();
        String keys = "name";
    
        String s = jedis.get(keys);
        System.out.println(s);
    
        String value = jedis.lpop("23");
        System.out.println(value);
        
        //归还对象
        pool.returnResource(jedis);
    
    
    }
}
