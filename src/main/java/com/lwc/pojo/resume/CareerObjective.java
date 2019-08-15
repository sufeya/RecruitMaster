package com.lwc.pojo.resume;

/**
 * 简历中的求职意向
 */

public class CareerObjective {


    //期待月薪
    private String salaryExpection;
    //期待工作地点
    private String preferredLocation;
    //期待从事职业
    private String preferredFunction;
    //期待工作性质
    private String jobType;



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
