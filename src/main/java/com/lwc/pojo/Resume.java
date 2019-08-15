package com.lwc.pojo;

import com.lwc.pojo.resume.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
/**
 * 简历的基本属性
 */
@Document(collection = "resume")
public class Resume {
    @Id
    private ObjectId _id;
    //简历id
    @Field("rId")
    private Integer rId;
    //所关联用户id
    @Field("uId")
    private Integer uId;


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

    //自我评价
    @Field("sa")
    private SelfAssessment sa;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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
