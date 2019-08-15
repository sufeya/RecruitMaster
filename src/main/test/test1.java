import com.lwc.dao.ResumDaoImpl;

import com.lwc.pojo.Resume;
import com.lwc.pojo.User;
import com.lwc.pojo.resume.ProjectExperience;
import com.lwc.pojo.resume.WorkExperience;
import org.bson.types.ObjectId;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;


public class test1 {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {

//       / um.insert(new User("21","刘",2));

        ResumDaoImpl rdi = new ResumDaoImpl();
        Resume resume = new Resume();
        resume.setrId(2);
        resume.setuId(3);
        WorkExperience we=new WorkExperience();
        we.setJobTitle("fsdfasadf");
        we.setCompany("fasdfasdf");
        we.setEndTime(new Date());
        resume.setWes(we);

       // rdi.addResum(resume);
        Resume sd=rdi.getResumeById(2);
        System.out.println(sd.getWes().getCompany());
    }
}
