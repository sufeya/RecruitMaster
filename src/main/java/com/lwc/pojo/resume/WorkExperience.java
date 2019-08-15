package com.lwc.pojo.resume;

import java.util.Date;

/**
 * 工作经验
 */
public class WorkExperience {
    //公司名称
    private String company;

    //职位名称:
    private String jobTitle;
    //在职时间
    private Date  startTime;
    //离职时间
    private Date endTime;


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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


}
