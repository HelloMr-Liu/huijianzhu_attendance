import com.alibaba.fastjson.JSON;
import com.huijianzhu.attendance.Attendance_8988;
import com.huijianzhu.attendance.definition.AttendanceUserDefinition;
import com.huijianzhu.attendance.service.AttendanceUserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述：当前类说说明
 *
 * @author 刘梓江
 * @date 2020/5/22  18:31
 */

@RunWith(SpringRunner.class)
@SpringBootTest( classes= Attendance_8988.class)
public class Test {

    @Autowired
    private AttendanceUserService attendanceUserService;


    @org.junit.Test
    public void test1(){
        AttendanceUserDefinition definition=new AttendanceUserDefinition();
        definition.setDeptNo("002");
        definition.setFileType("1");
        System.out.println(JSON.toJSON(attendanceUserService.findAllByQuery(definition)));
    }
}
