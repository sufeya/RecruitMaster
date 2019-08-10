package com.lwc.redis.aspectj;

import com.lwc.redis.annotation.GetCache;
import com.lwc.util.RedisCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.Method;

@Component
@Aspect
public class GetCachAop {
    @Autowired
    private RedisTemplate<Serializable,Object> redisTemplate;
   private RedisCache redisCache=new RedisCache();
   //定义切点
   @Pointcut("@annotation(com.lwc.redis.annotation.GetCache)")
    public void getCache(){
       System.out.println("获取内存数据切入点");
   }
   /*在所有标注了GetCache的地方切入*/
   @Around("getCache()")
    public Object beforeExec(ProceedingJoinPoint joinPoint){
       //生成redis中的id,根据自己指定的格式
       String redisKey=getCacheKey(joinPoint);

       //获取从redis中查询得到的对象
       Object object=redisCache.getDataFromRedis(redisKey);

       //如果查询到了
       if(null!=object){
           System.out.println("从redis中获取到了数据");
           return object;
       }else{
           System.out.println("从数据库中查询数据");
           //如果没有查询到，则在数据库中进行查询
           try {
               object=joinPoint.proceed();
           } catch (Throwable throwable) {
               throwable.printStackTrace();
           }
       }

       //在目标方法执行完之后：将查到的数据放入到redis中
       redisCache.setDataToRedis(redisKey,object);
       return object;
   }

    /**
     * 根据方法名参数名类名获取唯一的一个键值
     * 格式为your.package..classname.methodname(int).argsvalue123
     * @param joinPoint
     * @return
     */
    //变量没有用到时不让警告
   @SuppressWarnings("unused")
   private String getCacheKey(ProceedingJoinPoint joinPoint){
       //获取切入方法的一些相关的信息
       MethodSignature ms=(MethodSignature) joinPoint.getSignature();

       Method method=ms.getMethod();
       //获取注解中设置的对应参数
       String ActionName=method.getAnnotation(GetCache.class).value();
       String fieldList=method.getAnnotation(GetCache.class).name();
       for(String field:fieldList.split("."))
           ActionName+="."+field;

       //获取切点方法的参数
       String id=null;
       Object[] args=joinPoint.getArgs();
       if(args!=null && args.length>0)
           id=String.valueOf(args[0]);
       ActionName+="="+id;
       String redisKey=ms+"."+ActionName;
       return redisKey;
   }

   public void setRedisTemplate( RedisTemplate<Serializable, Object> redisTemplate){
       this.redisTemplate = redisTemplate;
   }
}
