package com.lwc.dao;

import com.lwc.dao.imp.ResumDaoI;
import com.lwc.pojo.Resume;
import com.lwc.pojo.resume.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.regex.Pattern;
@Component
public class ResumDaoImpl implements ResumDaoI {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void addResum(Resume resume) {
        mongoTemplate.insert(resume);
    }

    @Override
    //跟据用户id来更新用户的简历
    public void updateResum(Resume resume) {
        Criteria criteria = Criteria.where("rId").is(resume.getrId());
        Query query=new Query(criteria);
        Update update=getUpdate(resume);
        mongoTemplate.updateFirst(query,update,Resume.class);
    }

    @Override
    public List<Resume> getAllResume() {
        return null;
    }

    @Override
    public Resume getResumeById(int id) {
        Criteria criteria=Criteria.where("rId").is(id);
        Query query=new Query(criteria);
        return mongoTemplate.findOne(query, Resume.class);
    }

    @Override
    public void deleteReusmeById(int id) {
        Resume re=new Resume();
        re.setrId(id);
        mongoTemplate.remove(re);
    }

    //根据简历的条件获得查询
   private Query getQuery(Resume resume) {
        if (resume == null) {
            resume = new Resume();
        }
        Query query = new Query();
        if (resume.getrId() != null) {
            Criteria criteria = Criteria.where("rId").is(resume.getrId());
            query.addCriteria(criteria);
        }

        if(resume.getCos() !=null){
            CareerObjective cos=resume.getCos();
            Pattern pattern= Pattern.compile("^.*"+cos.getSalaryExpection()+".*$",Pattern.CASE_INSENSITIVE);
            Criteria criteria =Criteria.where("cos.salaryExpection").regex(pattern);
            pattern=Pattern.compile("^.*"+cos.getJobType()+".*$",Pattern.CASE_INSENSITIVE);
            Criteria criteria2=Criteria.where("cos.jobType").regex(pattern);
            pattern=Pattern.compile("^.*"+cos.getPreferredFunction()+".*$",Pattern.CASE_INSENSITIVE);
            Criteria criteria3=Criteria.where("cos.preferredLocation").regex(pattern);
            pattern=Pattern.compile("^.*"+cos.getPreferredFunction()+".*$",Pattern.CASE_INSENSITIVE);
            Criteria criteria4=Criteria.where("cos.preferredFunction").regex(pattern);
            query.addCriteria(criteria);
            query.addCriteria(criteria2);
            query.addCriteria(criteria3);
            query.addCriteria(criteria4);
        }
        return query;
    }

    public Update getUpdate(Resume resume){
        Update update=new Update();
        if(resume ==null){
            resume=new Resume();
        }
        if(resume.getTag()!=null)
            update.set("tag",resume.getTag());
        if(resume.getScore()!=null)
            update.set("score",resume.getScore());
        if(resume.getCos()!=null){
            CareerObjective co=resume.getCos();
            update.set("cos.preferredFunction",co.getPreferredFunction()).set("cos.salaryExpection",co.getSalaryExpection());
            update.set("cos.preferredLocation",co.getPreferredLocation()).set("cos.jobType",co.getJobType()).set("cos.tag",co.getTag());
        }
        if(resume.getEb() !=null){
            EducationBackground eb=resume.getEb();
            update.set("eb.school",eb.getSchool()).set("eb.startDate",eb.getStartDate());
            update.set("eb.endDate",eb.getEndDate()).set("eb.major",eb.getMajor()).set("eb.degree",eb.getDegree()).set("eb.tag",eb.getTag());
        }
        if(resume.getPe() != null){
            ProjectExperience pe=resume.getPe();
            update.set("pe.periodEnd",pe.getPeriodEnd()).set("pe.projectName",pe.getProjectName()).set("pe.periodStart",pe.getPeriodStart());
            update.set("pe.projectDesc",pe.getProjectDesc()).set("pe.personalDuty",pe.getPersonalDuty()).set("pe.tag",pe.getTag());
        }
        if(resume.getSa() !=null){
            update.set("sa.Description",resume.getSa().getDescription()).set("sa.tag",resume.getSa().getTag());
        }
        if(resume.getWd() !=null){
            WorkDisplay wd=resume.getWd();
            update.set("wd.workDescription",wd.getWorkDescription()).set("wd.workUrl",wd.getWorkUrl()).set("wd.tag",wd.getTag());
        }
        //更新工作经验
        if(resume.getWes() !=null){
            WorkExperience we=resume.getWes();
            update.set("wes.company",we.getCompany()).set("wes.jobTitle",we.getJobTitle());
            update.set("wes.startTime",we.getStartTime()).set("wes.endTime",we.getEndTime()).set("wes.tag",we.getTag());
        }
        return update;
    }

    //workExperiences
}
