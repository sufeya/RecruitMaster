package com.lwc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Iterator;
import java.util.Set;

/**
 * redis缓存工具类
 */
@Component
public class RedisCache {
    @Autowired
    private  JedisPool jedisPool;
    //从缓存中读取数据，进行反序列化
    public Object getDataFromRedis(String redisKey){

        Jedis jedis=jedisPool.getResource();
        byte[] result=jedis.get(redisKey.getBytes());

       //如果没有查询到，就返回空
        if(null==result)
            return null;
        return SerializableUtil.toObject(result);
    }

    //将数据库中查到的数据放入redis中
    public void setDataToRedis(String redisKey,Object obj){
        byte[] bytes =SerializableUtil.toByteArray(obj);
        Jedis jedis=jedisPool.getResource();
        String sucess=jedis.set(redisKey.getBytes(),bytes);
        if("OK".equals(sucess)){
            System.out.println("数据保存成功");
        }
    }


    //跟据传入的键值来删除数据
    public void delDateToRedis(String redisKey) {
        Jedis jedis = jedisPool.getResource();
        try {
            //只删除service类对应的所有缓存
            Set<String> set = jedis.keys("*"+redisKey + "*");
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String keyStr = it.next();
                System.out.println("根据key" + keyStr + "删除缓存信息");
                System.out.println(keyStr);
                jedis.del(keyStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }


}
