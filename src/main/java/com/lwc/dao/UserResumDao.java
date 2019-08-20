package com.lwc.dao;

import com.lwc.pojo.UserResume;
import com.lwc.pojo.resume.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserResumDao {
    @Autowired
   private MongoTemplate mongoTemplate;
            /*增加简历中的一些东西*/
    //增加一份简历
    public void insertUserResum(UserResume userResume){
        mongoTemplate.insert(userResume);
    }
    public void addWorkExperience(Integer uId,WorkExperience we){
       updatePart(uId,"wes",we);
    }
    public void addWorkDisplay(Integer uId,WorkDisplay wd){
        updatePart(uId,"wds",wd);
    }
    public void addProjectExperiences(Integer uId,ProjectExperience pe){
            updatePart(uId,"pes",pe);
    }
    public void addEducationBackground(Integer uId,EducationBackground eb){
        updatePart(uId,"ebs",eb);
    }
    public void updatePart(Integer uId,String key,Object value){
        Query query=Query.query(Criteria.where("uId").is(uId));
        Update update=new Update();
        update.addToSet(key,value);
    }
                /*查询简历*/
    //跟据用户id来查询一份简历
    public UserResume selectUserResum(Integer uId){
        Criteria criteria=Criteria.where("uId").is(uId);
        Query query=new Query(criteria);
       return  mongoTemplate.findOne(query,UserResume.class);
    }



                                /*更新操作*/
    //更新简历的其他部分
    public void  updateUserResume(UserResume userResume){
        Criteria criteria=Criteria.where("uId").is(userResume.getuId());
        Query query=new Query(criteria);
        Update update=getUpdate(userResume);
        mongoTemplate.updateFirst(query,update,UserResume.class);
    }
    //根据用户id和工作经验id
    public void updateWorkExperience(int uId,WorkExperience we){
        Update update=new Update();
        Query query=Query.query(Criteria.where("uId").is(uId).and("wes.wId").is(we.getwId()));
        update.set("wes.$.company",we.getCompany()).set("wes.$.jobTitle",we.getJobTitle());
        update.set("wes.$.startTime",we.getStartTime()).set("wes.$.endTime",we.getEndTime());
        mongoTemplate.updateFirst(query,update,UserResume.class);
    }
    //更新作品
    public void updateWorkDisplay(int uId,WorkDisplay wd){
        Update update=new Update();
        Query query=Query.query(Criteria.where("uId").is(uId).and("wds.wId").is(wd.getwId()));
        update.set("wds.$.workDescription",wd.getWorkDescription()).set("wds.$.workUr",wd.getWorkUrl());
        mongoTemplate.updateFirst(query,update,UserResume.class);
    }
    public void updateProjectExperiences(ProjectExperience pe,Integer uId){
        Update update=new Update();
        Query query=Query.query(Criteria.where("uId").is(uId).and("pes.pId").is(pe.getpId()));
        update.set("pes.$.projectName",pe.getProjectName()).set("pes.$.personalDuty",pe.getPersonalDuty());
        update.set("pes.$.projectDesc",pe.getProjectDesc()).set("pes.$.periodStart",pe.getPeriodStart());
        update.set("pes.$.periodEnd",pe.getPeriodEnd());
        mongoTemplate.updateFirst(query,update,UserResume.class);
    }

    public void updateEducationBackground(Integer uId,EducationBackground eb){
        Update update=new Update();
        Query query=Query.query(Criteria.where("uId").is(uId).and("ebs.eId").is(eb.geteId()));
        update.set("ebs.$.school",eb.getSchool()).set("ebs.$.major",eb.getMajor());
        update.set("ebs.$.startDate",eb.getStartDate()).set("ebs.$.endDate",eb.getEndDate());
        update.set("ebs.$.degree",eb.getDegree());
        mongoTemplate.updateFirst(query,update,UserResume.class);
    }

                        /*移除集合中属性*/
    //移除简历中某些集合的值
    public void removeWorkDisplay(Integer uId,WorkDisplay wd){
        removePart(uId,"wds.wId",wd.getwId(),"wds.$");
    }
    public void removeWorkExperience(Integer uId,WorkExperience we){
        removePart(uId,"wes.wId",we.getwId(),"wes.$");
    }
    public void removeProjectExperiences(Integer uId,ProjectExperience pe){
        removePart(uId,"pes.pId",pe.getpId(),"pes.$");
    }
    public void removeEducationBackground(Integer uId,EducationBackground eb){
        removePart(uId,"ebs.eId",eb.geteId(),"ebs.$");
    }
    /**
     *
     * @param uId 用户id
     * @param key 匹配集合中的键
     * @param id 集合中的值
     * @param uset 需要删除对应的字段
     */
    public void removePart(Integer uId, String key, ObjectId id,String uset){
        Query query=Query.query(Criteria.where("uId").is(uId).and(key).is(id));
        Update update=new Update();
        update.unset(uset);
        mongoTemplate.updateFirst(query,update,UserResume.class);
    }
    //获取更新
    public Update getUpdate(UserResume userResume){
        Update update=new Update();

        if(userResume.getCareerObjective()!=null){
            CareerObjective co=userResume.getCareerObjective();
            update.set("cos.salaryExpection",co.getSalaryExpection()).set("cos.preferredLocation",co.getPreferredLocation());
            update.set("cos.preferredFunction",co.getPreferredFunction()).set("cos.jobType",co.getJobType()).set("cos.tag",co.getTag());
        }
        if(userResume.getSelfAssessment() !=null){
            update.set("sa.Description",userResume.getSelfAssessment().getDescription());
        }
        if(userResume.getcTag() !=null)
            update.set("cTag",userResume.getcTag());
        if(userResume.geteTag() !=null)
            update.set("eTag",userResume.geteTag());
        if(userResume.getpTag() !=null)
            update.set("pTag",userResume.getpTag());
        if(userResume.getsTag()!=null)
            update.set("sTag",userResume.getsTag());
        if(userResume.getuTag() !=null)
            update.set("uTag",userResume.getuTag());
        if(userResume.getWeTag()!=null)
            update.set("uTag",userResume.getuTag());
        if(userResume.getwTag() !=null)
            update.set("wTag",userResume.getwTag());
        return update;
    }
}
