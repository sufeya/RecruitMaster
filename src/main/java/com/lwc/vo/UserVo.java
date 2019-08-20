package com.lwc.vo;

public class UserVo {
    private String tEmail;
    //用户登入的密码
    private String tPwd;
    //自动登入
    private int autoLogin ;

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

    public int getAutoLogin() {
        return autoLogin;
    }

    public void setAutoLogin(int autoLogin) {
        this.autoLogin = autoLogin;
    }
}
