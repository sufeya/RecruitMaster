package com.lwc.controller;

import com.lwc.pojo.User;
import com.lwc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
   private UserService userService;
    @RequestMapping("/showUser")
    public String showUser(){
       User user= userService.getUser(1);
        System.out.println(user.toString());
        return null;
    }
}
