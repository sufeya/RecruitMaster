package com.lwc.pojo.resume;

import java.util.Date;

public class ProjectExperience {
    private String projectName;
    private Date periodStart;
    private Date periodEnd;
    private String projectDesc;
    private String personalDuty;


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
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
