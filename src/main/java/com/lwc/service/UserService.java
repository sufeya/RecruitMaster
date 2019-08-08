package com.lwc.service;

import com.lwc.dao.UserDao;
import com.lwc.pojo.User;
import com.lwc.redis.annotation.GetCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @GetCache(name = "user" ,value = "id")
    public User getUser(Integer id){
        return userDao.selectUser(id);
    }
}
