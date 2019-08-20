package com.lwc.pojo.resume;

import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;

/**
 * 工作经验
 */
public class WorkExperience  implements Serializable {
    //公司名称
    private String company;

    //职位名称:
    private String jobTitle;
    //在职时间
    private String  startTime;
    //离职时间
    private String endTime;
    //用于区分集合中的某个元素
    private Integer tag;
    private ObjectId wId;

    public ObjectId getwId() {
        return wId;
    }

    public void setwId(ObjectId wId) {
        this.wId = wId;
    }



    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }



    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


}
