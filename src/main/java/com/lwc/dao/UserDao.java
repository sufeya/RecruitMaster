package com.lwc.dao;

import com.lwc.pojo.User;
import com.lwc.redis.annotation.DeleteCache;
import com.lwc.redis.annotation.GetCache;

import java.util.List;

public interface UserDao {
    public int addUser(User user);
    public List<User> getAllUser();
    public User selectUserByEmailAndPwd(User user);
    public User selectUserById(Integer id);

    public void updateUserById(User user);
}
