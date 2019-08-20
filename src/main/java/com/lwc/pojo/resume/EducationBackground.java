package com.lwc.pojo.resume;

import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;

public class EducationBackground implements Serializable {
    private String school;
    private String startDate;
    private String endDate;
    private String major;
    private String degree;
    private Integer  tag;
    private ObjectId eId;

    public ObjectId geteId() {
        return eId;
    }

    public void seteId(ObjectId eId) {
        this.eId = eId;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
