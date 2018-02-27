import org.junit.Test;

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
            System.out.println(" INSERT INTO users (userName,passWord,user_sex,nick_name) VALUES  (\""+username+"\", \""+password+"\", \""+userSex+"\",\""+nickName+"\");");
        }
    }
}
