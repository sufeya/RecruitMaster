package com.lwc.dao;

import com.lwc.pojo.UserTail;

public interface UserTailDao {
    public void updateUserTail(UserTail userTail);
    public void addUserTail(UserTail userTail);
    public UserTail selectUserTailById(Integer id);
    public void addUserImg(UserTail userTail);
}
