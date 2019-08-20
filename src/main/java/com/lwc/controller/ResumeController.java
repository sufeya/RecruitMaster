package com.lwc.controller;


import com.lwc.pojo.Resume;
import com.lwc.pojo.UserTail;
import com.lwc.pojo.resume.*;
import com.lwc.service.ResumeService;
import com.lwc.util.DateUtil;
import com.lwc.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    @RequestMapping("/resumeIndex")
    public String showResum(){
        return "interviewer/jianli";
    }
    //存储用户的图片
    @RequestMapping("/getImg")
    @ResponseBody
    public Map<String,String> saveImg(MultipartFile headPic, HttpServletRequest request){
        Map<String,String> map=new HashMap<>();
        UserTail userTail=new UserTail();
        String imgPath=FileUpload.upLoadImg(headPic, request.getServletContext().getRealPath("/"));
        //设置绑定用户的id
        userTail.settId(1);
        userTail.setuImg(imgPath);
        UserTail userTail1=resumeService.getUserTail(1);
        //如果在usertail中有用户信息则更新，否则添加
        if(userTail1!=null)
            resumeService.updateUserTail(userTail);
        else
            resumeService.addUserImg(userTail);
        map.put("content",imgPath);
        map.put("success",true+"");

        return map;
    }
    //ajax存储用户的一些详细信息
    @RequestMapping("/saveUserTail")
    @ResponseBody
    public Map<String,Object> saveUserTail(@RequestBody UserTail userTail,HttpSession session){
       /* User user= (User) session.getAttribute("user");
        int rid=user.gettId();*/
       Integer userId=1;
        userTail.settId(userId);
        Resume resume=resumeService.getResume(userId);
        resumeService.updateUserTail(userTail);
        Map<String,Object> map=new HashMap<>();
        map.put("success",true+"");
        map.put("resume",userTail);
        map.put("refreshTime", DateUtil.dateToString(new Date()));
        map.put("isNew",true);
        //给简历进行给分
        if(resume!=null){
            if(resume.getTag()==null){
                resume.setScore(resume.getScore()+20);
                resume.setTag(1);
                System.out.println("设置分数");
                resumeService.updateResum(resume);
            }
        }
        else{
            resume=new Resume();
            resume.setrId(userId);
            resume.setScore(20);
            resume.setTag(1);
            resumeService.addResum(resume);
        }
        session.setAttribute("userTail",resumeService.getUserTail(userId));
        //基础分数为20分
        map.put("score",resume.getScore());
        return map;
    }

    //ajax存储简历的期望工作
    @RequestMapping("/saveCareerObjective")
    @ResponseBody
    public Map<String,Object> getCareerObjective(@RequestBody CareerObjective objective, HttpSession session){
        //用户id现固定为1
        Integer userId=1;
        Map<String,Object> map=new HashMap<String,Object>();
        //后面整合从session中获取id
        /*User user=(User)session.getAttribute("user");
        int rId=user.gettId();*/
        Resume resume=resumeService.getResume(userId);
        if(resume==null){
            //如果数据库中没有对应的数据,则新加
            resume=new Resume();
            resume.setrId(userId);
            //该模块分数为15分
            resume.setScore(15);
            objective.setTag(1);
            resume.setCos(objective);
            resumeService.addResum(resume);
        }else{
            //数据库中存在则更新数据库
            if(resume.getCos()==null){
                resume.setScore(resume.getScore()+15);
                objective.setTag(1);
            }else
            {
                if(resume.getCos().getTag()==null)
                    resume.setScore(resume.getScore()+15);
                objective.setTag(1);
            }
            resume.setCos(objective);
            resumeService.updateResum(resume);
        }
        session.setAttribute("resume",resume);
        map.put("resume",objective);
        map.put("success",true);
        map.put("score",resume.getScore());
        return map;
    }
    @RequestMapping("/getWorkExperience")
    @ResponseBody
    public Map<String,Object> getWorkExperience(@RequestBody WorkExperience workExperience,HttpSession session){
        Integer userId=1;
        Map<String,Object> map=new HashMap<>();
        Resume resume=resumeService.getResume(userId);
        if(resume==null){
            //如果数据库中没有对应的数据,则新加
            resume=new Resume();
            resume.setrId(userId);
            //该模块分数为15分
            resume.setScore(15);
            workExperience.setTag(1);
            resume.setWes(workExperience);
            resumeService.addResum(resume);
        }else{
            //数据库中存在则更新数据库
            if(resume.getWes()==null){
                resume.setScore(resume.getScore()+15);
                workExperience.setTag(1);
            }else
            {
                if(resume.getWes().getTag()==null)
                    resume.setScore(resume.getScore()+15);
                workExperience.setTag(1);
            }
            resume.setWes(workExperience);
            resumeService.updateResum(resume);
        }
        session.setAttribute("resume",resume);
        map.put("workExperiences",workExperience);
        map.put("success",true);
        map.put("refreshTime",DateUtil.dateToString(new Date()));
        map.put("score",resume.getScore());
        return map;
    }
    @RequestMapping("/getProjectExperience")
    @ResponseBody
    public Map<String ,Object> getProjectExperience(@RequestBody ProjectExperience experience,HttpSession session){
        Map<String,Object> map=new HashMap<String,Object>();
        Integer userId=1;
        Resume resume=resumeService.getResume(userId);
        if(resume==null){
            //如果数据库中没有对应的数据,则新加
            resume=new Resume();
            resume.setrId(userId);
            //该模块分数为15分
            resume.setScore(15);
            experience.setTag(1);
            resume.setPe(experience);
            resumeService.addResum(resume);
        }else{
            //数据库中存在则更新数据库
            if(resume.getWes()==null){
                resume.setScore(resume.getScore()+15);
               experience.setTag(1);
            }else
            {
                if(resume.getWes().getTag()==null)
                    resume.setScore(resume.getScore()+15);
                experience.setTag(1);
            }
            resume.setPe(experience);
            resumeService.updateResum(resume);
        }
        session.setAttribute("resume",resume);
        map.put("success",true);
        map.put("score",resume.getScore());
        map.put("refreshTime",DateUtil.dateToString(new Date()));
        map.put("projectExperience",experience);
        return map;
    }
    @RequestMapping("/getSelfAssessment")
    @ResponseBody
    public Map<String,Object> getSelfAssessment(@RequestBody SelfAssessment selfAssessment,HttpSession session){
        Map<String,Object> map=new HashMap<String,Object>();
        Integer userId=1;
        Resume resume=resumeService.getResume(userId);
        if(resume==null){
            //如果数据库中没有对应的数据,则新加
            resume=new Resume();
            resume.setrId(userId);
            //该模块分数为15分
            resume.setScore(15);
            selfAssessment.setTag(1);
            resume.setSa(selfAssessment);
            resumeService.addResum(resume);
        }else{
            //数据库中存在则更新数据库
            if(resume.getSa()==null){
                resume.setScore(resume.getScore()+15);
                selfAssessment.setTag(1);
            }else
            {
                if(resume.getWes().getTag()==null)
                    resume.setScore(resume.getScore()+15);
                selfAssessment.setTag(1);
            }
            resume.setSa(selfAssessment);
            resumeService.updateResum(resume);
        }
        session.setAttribute("resume",resume);
        map.put("score",resume.getScore());
        map.put("refreshTime",DateUtil.dateToString(new Date()));
        map.put("success",true);
        map.put("resume",selfAssessment);
        return map;
    }
    @RequestMapping("/getWorkDisplay")
    @ResponseBody
    public Map<String,Object> getWorkDisplay(@RequestBody WorkDisplay workDisplay,HttpSession session){
        System.out.println("工作输出"+workDisplay.getWorkDescription());
        Map<String,Object> map=new HashMap<>();
        Integer userId=1;
        Resume resume=resumeService.getResume(userId);
        if(resume==null){
            //如果数据库中没有对应的数据,则新加
            resume=new Resume();
            resume.setrId(userId);
            //该模块分数为15分
            resume.setScore(15);
           workDisplay.setTag(1);
            resume.setWd(workDisplay);
            resumeService.addResum(resume);
        }else{
            //数据库中存在则更新数据库
            if(resume.getSa()==null){
                resume.setScore(resume.getScore()+15);
                workDisplay.setTag(1);
            }else
            {
                if(resume.getWes().getTag()==null)
                    resume.setScore(resume.getScore()+15);
                workDisplay.setTag(1);
            }
            resume.setWd(workDisplay);
            resumeService.updateResum(resume);
        }
        session.setAttribute("resume",resume);
        map.put("score",resume.getScore());
        map.put("refreshTime",DateUtil.dateToString(new Date()));
        map.put("success",true);
        map.put("workShow",workDisplay);
        return map;
    }
    @RequestMapping("/getEducationBackround")
    @ResponseBody
    public Map<String ,Object> getEducationBackround(@RequestBody EducationBackground educationBackground,HttpSession session){
        Map<String,Object> map =new HashMap<>();
        Integer userId=1;
        Resume resume=resumeService.getResume(userId);
        System.out.println("获取学校"+educationBackground.getSchool());
        if(resume==null){
            //如果数据库中没有对应的数据,则新加
            resume=new Resume();
            resume.setrId(userId);
            //该模块分数为15分
            resume.setScore(15);
            educationBackground.setTag(1);
            resume.setEb(educationBackground);
            resumeService.addResum(resume);
        }else{
            //数据库中存在则更新数据库
            if(resume.getEb()==null){
                resume.setScore(resume.getScore()+15);
                educationBackground.setTag(1);
            }else
            {
                if(resume.getEb().getTag()==null)
                    resume.setScore(resume.getScore()+15);
                educationBackground.setTag(1);
            }
            resume.setEb(educationBackground);
            resumeService.updateResum(resume);
        }
        session.setAttribute("resume",resume);
        map.put("score",resume.getScore());
        map.put("refreshTime",DateUtil.dateToString(new Date()));
        map.put("success",true);
        map.put("educationExperiences",educationBackground);
        return map;
    }
    @RequestMapping("/showResume")
    public String resumePreview(){
        return "interviewer/preview";
    }

}
