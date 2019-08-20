package com.lwc.pojo.resume;

import org.bson.types.ObjectId;

import java.io.Serializable;

/**
 * 简历中的求职意向
 */

public class CareerObjective implements Serializable {

    private ObjectId sId;

    public ObjectId getsId() {
        return sId;
    }

    public void setsId(ObjectId sId) {
        this.sId = sId;
    }

    //期待月薪
    private String salaryExpection;
    //期待工作地点
    private String preferredLocation;
    //期待从事职业
    private String preferredFunction;
    //期待工作性质
    private String jobType;
    //判断是否算入分数
    private Integer tag;

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getSalaryExpection() {
        return salaryExpection;
    }

    public void setSalaryExpection(String salaryExpection) {
        this.salaryExpection = salaryExpection;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public String getPreferredFunction() {
        return preferredFunction;
    }

    public void setPreferredFunction(String preferredFunction) {
        this.preferredFunction = preferredFunction;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
}
