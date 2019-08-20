package com.lwc.service;

import com.lwc.dao.UserDao;
import com.lwc.pojo.User;
import com.lwc.redis.annotation.DeleteCache;
import com.lwc.redis.annotation.GetCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @DeleteCache
    public int userReg(User user){
       return userDao.addUser(user);

    }
    //判断用户账号是否存在
    public boolean accountConfine(User user){
        for(User user1:userDao.getAllUser()){
            if(user.gettEmail().equals(user1.gettEmail()))
                return true;
        }
        return false;
    }
    //跟据用户密码和邮箱查询用户
    public User userConfine(User user){
        return userDao.selectUserByEmailAndPwd(user);
    }
    public User getUser(Integer id){
        return userDao.selectUserById(id);
    }

    @GetCache(name = "getAllUser")
    public List<User> getAllUser(){
        return userDao.getAllUser();
    }
    @DeleteCache
    public void changePwd(User user){
        userDao.updateUserById(user);
    }
}
