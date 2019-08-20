package com.lwc.pojo.resume;

import org.bson.types.ObjectId;

import java.io.Serializable;


public class ProjectExperience implements Serializable {
    private String projectName;
    private String periodStart;
    private String periodEnd;
    private String projectDesc;
    private String personalDuty;
    private Integer tag;
    private ObjectId pId;

    public ObjectId getpId() {
        return pId;
    }

    public void setpId(ObjectId pId) {
        this.pId = pId;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(String periodStart) {
        this.periodStart = periodStart;
    }

    public String getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(String periodEnd) {
        this.periodEnd = periodEnd;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getPersonalDuty() {
        return personalDuty;
    }

    public void setPersonalDuty(String personalDuty) {
        this.personalDuty = personalDuty;
    }


}
