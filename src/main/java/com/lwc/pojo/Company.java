package com.lwc.pojo;
public class Company {
    //公司id
    private Integer cId;
    //公司名字
    private String cName;
    //公司logo
    private String cLogo;
    //公司网站
    private String cWebsite;
    //公司地址
    private String cLoc;
    //公司所处领域
    private String cField;
    //公司规模
    private String cScale;
    //公司发展阶段
    private String cMoment;
    //公司结构
    private String cStruct;
    //公司简介
    private String cIntroduce;
    //公司标签，用于存monogo的存储id
    private int cTag;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcLogo() {
        return cLogo;
    }

    public void setcLogo(String cLogo) {
        this.cLogo = cLogo;
    }

    public String getcWebsite() {
        return cWebsite;
    }

    public void setcWebsite(String cWebsite) {
        this.cWebsite = cWebsite;
    }

    public String getcLoc() {
        return cLoc;
    }

    public void setcLoc(String cLoc) {
        this.cLoc = cLoc;
    }

    public String getcField() {
        return cField;
    }

    public void setcField(String cField) {
        this.cField = cField;
    }

    public String getcScale() {
        return cScale;
    }

    public void setcScale(String cScale) {
        this.cScale = cScale;
    }

    public String getcMoment() {
        return cMoment;
    }

    public void setcMoment(String cMoment) {
        this.cMoment = cMoment;
    }

    public String getcStruct() {
        return cStruct;
    }

    public void setcStruct(String cStruct) {
        this.cStruct = cStruct;
    }

    public String getcIntroduce() {
        return cIntroduce;
    }

    public void setcIntroduce(String cIntroduce) {
        this.cIntroduce = cIntroduce;
    }

    public int getcTag() {
        return cTag;
    }

    public void setcTag(int cTag) {
        this.cTag = cTag;
    }
}
