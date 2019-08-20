package com.lwc.redis.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)//目标为方法
@Retention(RetentionPolicy.RUNTIME)//注解在类中存在，运行时通过反射获取
@Documented
@Inherited
public @interface DeleteCache {
}
