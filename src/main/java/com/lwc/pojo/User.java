package com.lwc.pojo;


import java.io.Serializable;

public class User implements Serializable {

   private Integer tId;
   //用户的email
   private String tEmail;
   //用户登入的密码
   private String tPwd;
   //用户是找工作，还是发布职位
   private Integer tFlag;
   //用户是绑定简历，还是绑定公司
   private Integer tBound;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettEmail() {
        return tEmail;
    }

    public void settEmail(String tEmail) {
        this.tEmail = tEmail;
    }

    public String gettPwd() {
        return tPwd;
    }

    public void settPwd(String tPwd) {
        this.tPwd = tPwd;
    }

    public Integer gettFlag() {
        return tFlag;
    }

    public void settFlag(Integer tFlag) {
        this.tFlag = tFlag;
    }

    public Integer gettBound() {
        return tBound;
    }

    public void settBound(Integer tBound) {
        this.tBound = tBound;
    }
}
