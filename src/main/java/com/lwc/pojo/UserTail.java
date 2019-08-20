package com.lwc.pojo;

/**
 * 用户账号的一些细节信息
 */
public class UserTail {
    //用户的id
    private Integer uId;
    //用户的姓名
    private String uName;
    //用户的电话
    private String uMobile;
    //用户信息
    private String uSex;
    //用户邮箱
    private String uEmail;
    //用户当前的工作状态
    private String uStatu;
    //用户的文化水平
    private String uEducation;
    //绑定用户账号
    private Integer tId;
    //用户的照片
    private String uImg;
    private String uWorkyear;

    public String getuWorkyear() {
        return uWorkyear;
    }

    public void setuWorkyear(String uWorkyear) {
        this.uWorkyear = uWorkyear;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuMobile() {
        return uMobile;
    }

    public void setuMobile(String uMobile) {
        this.uMobile = uMobile;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuStatu() {
        return uStatu;
    }

    public void setuStatu(String uStatu) {
        this.uStatu = uStatu;
    }

    public String getuEducation() {
        return uEducation;
    }

    public void setuEducation(String uEducation) {
        this.uEducation = uEducation;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getuImg() {
        return uImg;
    }

    public void setuImg(String uImg) {
        this.uImg = uImg;
    }
}
