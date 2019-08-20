package com.lwc.service;

import com.lwc.dao.ResumDaoImpl;
import com.lwc.dao.UserTailDao;
import com.lwc.pojo.Resume;
import com.lwc.pojo.UserTail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {
    @Autowired
    private ResumDaoImpl resumDao;
    @Autowired
    private UserTailDao userTailDao;

    public Resume getResume(int id){
        return  resumDao.getResumeById(id);
    }

    public void addUserImg(UserTail userTail){
        userTailDao.addUserImg(userTail);
    }
    public void updateUserTail(UserTail userTail){
        userTailDao.updateUserTail(userTail);
    }
    public UserTail  getUserTail(Integer id){
        return userTailDao.selectUserTailById(id);
    }
    //更新简历
    public void updateResum(Resume resume){
        resumDao.updateResum(resume);
    }
    //添加简历
    public void addResum(Resume resume){
        resumDao.addResum(resume);
    }
}
