import com.lwc.base.BaseTest;
import com.lwc.dao.UserDao;
import com.lwc.dao.UserResumDao;
import com.lwc.pojo.Resume;
import com.lwc.pojo.User;
import com.lwc.pojo.UserResume;
import com.lwc.pojo.resume.CareerObjective;
import com.lwc.pojo.resume.EducationBackground;
import com.lwc.pojo.resume.SelfAssessment;
import com.lwc.service.ResumeService;
import com.lwc.service.UserService;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;


public class test1 extends BaseTest {
    @Autowired
    private UserService userService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private UserResumDao userResumDao;
    @Test
    public void test4() throws IllegalAccessException, InstantiationException {
      /*UserResume userResume= new UserResume();
        SelfAssessment selfAssessment=new SelfAssessment();
        selfAssessment.setDescription("dfasfasdf");
        selfAssessment.setTag(1);
      userResume.setSelfAssessment(selfAssessment);
        List<EducationBackground> ebs=new ArrayList<>();
        EducationBackground eb=new EducationBackground();
        eb.setDegree("博士");
        eb.setTag(1);
        eb.setSchool("小");
        eb.seteId(new ObjectId());
        ebs.add(eb);
        EducationBackground eb2=new EducationBackground();
        eb2.setSchool("学士");
        eb2.setDegree("单位工会");
        eb2.seteId(new ObjectId());
        ebs.add(eb2);
        userResume.setEducationBackgrounds(ebs);
        userResume.setuId(1);
       userResumDao.insertUserResum(userResume);*/
     /* UserResume userResume=userResumDao.selectUserResum(1);
      EducationBackground eb=userResume.getEducationBackgrounds().get(0);
      ;*/
      ObjectId objectId=new ObjectId("5d5a4f14c6eb9f11245caed5");
      EducationBackground eb2=new EducationBackground();
      eb2.setDegree("网吧");
      eb2.setEndDate("dfasdf1fsdf");
      eb2.seteId(objectId);
      //userResumDao.updateEducationBackground(1,eb2);
      userResumDao.removeEducationBackground(1,eb2);
    }
}
