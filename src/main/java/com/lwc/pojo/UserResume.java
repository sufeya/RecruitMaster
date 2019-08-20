package com.lwc.pojo;

import com.lwc.pojo.resume.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * 真实模拟简历
 */
@Document(collection = "userResume")
public class UserResume {
    private String resumeName;
    @Id
    private ObjectId _id;
    @Field("uId")
    //用于绑定用户id
    private Integer uId;
    //判断用户细节是否被计分
    private Integer uTag;
    @Field("cb")
    //用户期望工作
    private CareerObjective careerObjective;
    //用于标记该项是否被计分
    private Integer cTag;
    //用户的学历，有多个用集合来进行存储
    @Field("ebs")
    private List<EducationBackground> educationBackgrounds;
    private Integer eTag;
    //项目的工作经验
    @Field("pes")
    private List<ProjectExperience> projectExperiences;
    private Integer pTag;
    //作品展示
    @Field("wds")
    private List<WorkDisplay> workDisplays;
    private Integer wTag;
    //自我介绍
    @Field("sa")
    private SelfAssessment selfAssessment;
    private Integer sTag;
    //工作经验
    @Field("wes")
    private List<WorkExperience> workExperiences;
    private Integer weTag;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getuTag() {
        return uTag;
    }

    public void setuTag(Integer uTag) {
        this.uTag = uTag;
    }

    public CareerObjective getCareerObjective() {
        return careerObjective;
    }

    public void setCareerObjective(CareerObjective careerObjective) {
        this.careerObjective = careerObjective;
    }

    public Integer getcTag() {
        return cTag;
    }

    public void setcTag(Integer cTag) {
        this.cTag = cTag;
    }

    public List<EducationBackground> getEducationBackgrounds() {
        return educationBackgrounds;
    }

    public void setEducationBackgrounds(List<EducationBackground> educationBackgrounds) {
        this.educationBackgrounds = educationBackgrounds;
    }

    public Integer geteTag() {
        return eTag;
    }

    public void seteTag(Integer eTag) {
        this.eTag = eTag;
    }

    public List<ProjectExperience> getProjectExperiences() {
        return projectExperiences;
    }

    public void setProjectExperiences(List<ProjectExperience> projectExperiences) {
        this.projectExperiences = projectExperiences;
    }

    public Integer getpTag() {
        return pTag;
    }

    public String getResumeName() {
        return resumeName;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public void setpTag(Integer pTag) {
        this.pTag = pTag;
    }

    public List<WorkDisplay> getWorkDisplays() {
        return workDisplays;
    }

    public void setWorkDisplays(List<WorkDisplay> workDisplays) {
        this.workDisplays = workDisplays;
    }

    public Integer getwTag() {
        return wTag;
    }

    public void setwTag(Integer wTag) {
        this.wTag = wTag;
    }

    public SelfAssessment getSelfAssessment() {
        return selfAssessment;
    }

    public void setSelfAssessment(SelfAssessment selfAssessment) {
        this.selfAssessment = selfAssessment;
    }

    public Integer getsTag() {
        return sTag;
    }

    public void setsTag(Integer sTag) {
        this.sTag = sTag;
    }

    public List<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    public void setWorkExperiences(List<WorkExperience> workExperiences) {
        this.workExperiences = workExperiences;
    }

    public Integer getWeTag() {
        return weTag;
    }

    public void setWeTag(Integer weTag) {
        this.weTag = weTag;
    }
}
