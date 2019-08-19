package com.lwc.dao.imp;

import com.lwc.pojo.User;

import java.util.List;

public interface UserDao {
    public int addUser(User user);
    public List<User> getAllUser();
}
