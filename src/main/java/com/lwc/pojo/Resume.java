package com.lwc.pojo;

import com.lwc.pojo.resume.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

/**
 * 简历的基本属性
 */
@Document(collection = "resume")
public class Resume implements Serializable {
    @Id
    private ObjectId _id;
    //所关联用户id
    @Field("rId")
    private Integer rId;

    @Field("rName")
    private String rName;

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    //求职意向
    @Field("cos")
    private CareerObjective cos;
    //工作经验
    @Field("wes")
    private WorkExperience wes;
    //教育背景
    @Field("eb")
    private EducationBackground eb;

    //作品展示
    @Field("wd")
   private WorkDisplay wd;
    //项目经验
    @Field("pe")
    private ProjectExperience pe;

    //用于标记用户模块是否算了分
    private Integer tag;
    //用于区分工作经验是否打分
    private Integer weTag;

    public Integer getWeTag() {
        return weTag;
    }

    public void setWeTag(Integer weTag) {
        this.weTag = weTag;
    }

    /*private List<WorkExperience> workExperiences;*/

  /*  public List<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    public void setWorkExperiences(List<WorkExperience> workExperiences) {
        this.workExperiences = workExperiences;
    }*/

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    //自我评价
    @Field("sa")
    private SelfAssessment sa;
    @Field("score")
    private Integer score;
    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public CareerObjective getCos() {
        return cos;
    }

    public void setCos(CareerObjective cos) {
        this.cos = cos;
    }

    public WorkExperience getWes() {
        return wes;
    }

    public void setWes(WorkExperience wes) {
        this.wes = wes;
    }

    public EducationBackground getEb() {
        return eb;
    }

    public void setEb(EducationBackground eb) {
        this.eb = eb;
    }

    public WorkDisplay getWd() {
        return wd;
    }

    public void setWd(WorkDisplay wd) {
        this.wd = wd;
    }

    public ProjectExperience getPe() {
        return pe;
    }

    public void setPe(ProjectExperience pe) {
        this.pe = pe;
    }

   public SelfAssessment getSa() {
        return sa;
    }

    public void setSa(SelfAssessment sa) {
        this.sa = sa;
    }
}
