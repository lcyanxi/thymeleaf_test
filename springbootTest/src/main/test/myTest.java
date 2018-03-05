import org.junit.Test;

import java.util.Date;

/**
 * Created by lichang on 2018/2/27
 */
public class myTest {


    @Test
    public void test(){
        for (int i=0;i<100;i++){
            String username="username"+i;
            String password="password"+i;
            String userSex="userSex"+i;
            String nickName="nickName"+i;
            
            System.out.println(" INSERT INTO users (shell_name,shell_url,job_name,statudate,consum_time,min_time,max_time,job_time) VALUES  (\""+username+"\", \""+password+"\", \""+userSex+"\",\""+nickName+"\");");
        }
    }

    @Test
    public void mytest(){



    }
}
