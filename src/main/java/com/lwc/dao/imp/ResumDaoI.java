package com.lwc.dao.imp;

import com.lwc.pojo.Resume;

import java.util.List;
import java.util.Map;

public interface ResumDaoI {
    //增加简历
    public void addResum(Resume resume);
    //更新简历
    public void updateResum(Resume resume);
    //获得所有的简历
    public List<Resume> getAllResume();
    //根据简历id来获取简历
    public Resume getResumeById(int id);
    //根据id来删除简历
    public void deleteReusmeById(int id);
}
