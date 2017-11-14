package com.fxb.redisLearn.dao;

import com.fxb.redisLearn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

/**
 * @author fangxiaobai
 * @date 2017/11/2 16:49.
 * @description UserDao
 *
 *      User 数据持久层
 */
public class UserDao {
    
    @Autowired
    private RedisTemplate<Serializable,Serializable> redisTemplate;
    
    public void setRedisTemplate(RedisTemplate <Serializable, Serializable> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    
    public RedisTemplate <Serializable, Serializable> getRedisTemplate() {
        return redisTemplate;
    }
    
    /**
     *  保存
     * 传入参数，需要final标识，禁止方法内修改。
     调用RedisConnection的set方法实现Redis的SET命令。
     不管是Key，还是Value都需要进行Serialize。
     序列化操作，最好使用RedisTemplate提供的Serializer来完成
     * @param user
     */
    public void set(final User user){
        redisTemplate.execute(new RedisCallback <Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(
                redisTemplate.getStringSerializer().serialize("user.id"+user.getId()),
                        redisTemplate.getStringSerializer().serialize("user.username"+user.getUsername()));
                return null;
            }
        });
    }
    
    /**
     * 获取
     * @param id key
     * @return
     */
    public User get(final String id){
        return redisTemplate.execute(new RedisCallback <User>() {
            @Override
            public User doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] key = redisTemplate.getStringSerializer().serialize("user.id" + id);
                if(connection.exists(key)) {
                    byte[] value = connection.get(key);
                    String deserializeValue = redisTemplate.getStringSerializer().deserialize(value);
                    User user = new User();
                    user.setId(id);
                    user.setUsername(deserializeValue);
                    return user;
                }
            return  null;
            }
        });
    }
    
    /**
     * 删除
     * @param id key
     */
    public void del(final String id){
        redisTemplate.execute(new RedisCallback <Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] key = redisTemplate.getStringSerializer().serialize(id);
                if(connection.exists(key)) {
                    connection.del(key);
                }
                return null;
            }
        });
    }
    
    
    
}
