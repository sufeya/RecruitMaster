package com.lwc.controller;


import com.lwc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/test")
    public String myTest(){
        return "index";
    }
    @RequestMapping("/login")
    public String userLogin(){
        return "login";
    }
    @RequestMapping("/doLogin")
    public String doLogin(User user){
        return "";
    }
    public String userReg(User user){
        return "";
    }
}
