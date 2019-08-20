package com.lwc.redis.aspectj;

import com.lwc.util.RedisCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DeleteCachAop {
    @Autowired
    private RedisCache redisCache;

    @Pointcut("@annotation(com.lwc.redis.annotation.DeleteCache)")
    public void deleteCache(){
        System.out.println("清除缓存中的数据");
    }
    @Around("deleteCache()")
    public Object handleCacheEvict(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取key前缀
        String className = joinPoint.getTarget().getClass().getName();
        System.out.println("获取的类名"+className);
        Object result = joinPoint.proceed();
        //批量删除
        redisCache.delDateToRedis(className + ".");
        return result;
    }

}
