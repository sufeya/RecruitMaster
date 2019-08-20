package com.lwc.controller;


import com.lwc.pojo.User;
import com.lwc.service.UserService;
import com.lwc.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public String myTest(){
        return "index";
    }
    //获取登入界面
    @RequestMapping("/login")
    public String userLogin(HttpSession session,HttpServletRequest request){
        //实现自动登入
       User user=(User) session.getAttribute("user");
       if(user !=null){
           return "/index";
       }else{
           Cookie[] cookies=request.getCookies();
           User user1=null;
           if(cookies!=null){
               for(Cookie cookie:cookies){
                   if("uId".equals(cookie.getName())){
                       user1=userService.getUser(Integer.valueOf(cookie.getValue()));
                       session.setAttribute("user",user1);
                       break;
                   }
               }
           }
           if(user1==null){
               return "/login";
           }else{
               return "/index";
           }

       }

    }

    //处理登入
    @RequestMapping("/doLogin")
    @ResponseBody
    public Map<String,String> doLogin(@RequestBody UserVo userVo, HttpServletResponse response,HttpSession session){
        Map<String,String> map=new HashMap<>();
        User user=new User();
        user.settEmail(userVo.gettEmail());
        user.settPwd(userVo.gettPwd());
        User confinedUser=userService.userConfine(user);
        //如果用户账号密码正确
        if(confinedUser!=null){
            session.setAttribute("user",confinedUser);
            if(userVo.getAutoLogin()==1)
            {
                Cookie cookie=new Cookie("uId",user.gettId()+"");
                cookie.setMaxAge(24 * 3600);
                response.addCookie(cookie);
            }
            map.put("result","success");
            return map;
        }
        map.put("result","error");
        return map;
    }
    //获取用户注册界面
    @RequestMapping("/regs")
    public String userReg(){
        return "register";
    }

    //用于检查
    @RequestMapping("/checkReg")
    @ResponseBody
    public Map<String,String> checkReg(@RequestBody User user, HttpSession session){
        Map<String ,String> map=new HashMap<>();
        if(userService.accountConfine(user))
        {
            map.put("result","该账号已经存在");
            return  map;
        }else{
            if(userService.userReg(user)>0){
                map.put("result","sucess");
                session.setAttribute("user",user);
            } else
                map.put("resul","error");
        }
        return map;
    }
}
