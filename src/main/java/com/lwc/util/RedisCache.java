package com.lwc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.*;
import java.util.concurrent.Callable;

/**
 * redis缓存工具类
 */
public class RedisCache  {
    @Autowired
    private JedisPool jedisPool;
    //从缓存中读取数据，进行反序列化
    public Object getDataFromRedis(String redisKey){
        Jedis jedis=jedisPool.getResource();
        byte[] result=jedis.get(redisKey.getBytes());
       //如果没有查询到，就返回空
        if(null==result)
            return null;
        return SerializableUtil.toObject(result);
    }

    //将数据库中查道德数据放入redis中
    public void setDataToRedis(String redisKey,Object obj){
        byte[] bytes =SerializableUtil.toByteArray(obj);
        Jedis jedis=jedisPool.getResource();
        String sucess=jedis.set(redisKey.getBytes(),bytes);
        if("OK".equals(sucess)){
            System.out.println("数据保存成功");
        }
    }
}
