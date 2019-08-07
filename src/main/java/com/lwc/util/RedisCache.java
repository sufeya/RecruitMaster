package com.lwc.util;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.*;
import java.util.concurrent.Callable;

/**
 * redis缓存工具类
 */
public class RedisCache<T> implements Cache {
    private RedisTemplate<String, T> redisTemplate;
    private String name;
    public RedisTemplate<String,T>getRedisTemplate(){
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, T> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    public void setName(String name){
        this.name=name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return this.redisTemplate;
    }

    //将redis中的值根据键值获取出来，存入到ValueWrapper中
    @Override
    public ValueWrapper get(Object key) {
        final  String keyf=key.toString();
        Object object=null;
        object=redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] key=keyf.getBytes();
                byte[] value=redisConnection.get(key);
                if(value==null){
                    return null;
                }
                return toObject(value);
            }
        });
        return (object !=null ? new SimpleValueWrapper(object):null);
    }

    @Override
    public <T> T get(Object o, Class<T> aClass) {
        return null;
    }

    @Override
    public <T> T get(Object o, Callable<T> callable) {
        return null;
    }
    //将对象存入到redis中
    @Override
    public void put(Object key, Object val) {
        final  String keyf=key.toString();
        final  Object valuef=val;
        final  long liveTime=86400;
        redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] keyb=keyf.getBytes();
                byte[] valueb=toByteArray(valuef);
                redisConnection.set(keyb,valueb);
                if(liveTime>0)
                    redisConnection.expire(keyb,liveTime);
                return 1l;
            }
        });
    }

    @Override
    public ValueWrapper putIfAbsent(Object o, Object o1) {
        return null;
    }
    //删除所给定的键值
    @Override
    public void evict(Object key) {
        final  String keyf=key.toString();
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.del(keyf.getBytes());
            }
        });

    }
    //
    @Override
    public void clear() {
        redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
               redisConnection.flushDb();
                return "ok";
            }
        });
    }
    //将字节数组反序列化为对象
    private Object toObject(byte[] bytes){
        Object obj=null;
        try{
            ByteArrayInputStream bis=new ByteArrayInputStream(bytes);
            ObjectInputStream ois=new ObjectInputStream(bis);
            obj=ois.read();
            ois.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
    //将对象序列化为字节数组
    private byte[] toByteArray(Object obj){
        byte[] bytes =null;
        ByteArrayOutputStream bos =new ByteArrayOutputStream();
        try{
            ObjectOutputStream oos=new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes=bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
