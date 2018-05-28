import douguo.util.DateUtil;
import douguo.util.ToolRandoms;
import org.junit.Test;

import java.util.Date;
import java.util.Random;


/**
 * Created by lichang on 2018/2/27
 */
public class myTest {

    @Test
    public void test2(){
       String id= ToolRandoms.randomCode8();
       System.out.println(id);
    }


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
        Random random=new Random();
        for(int i=0;i<10;i++){
            String pname="商品"+i;
            String color="brown"+i;
            String  price="5"+ Math.abs(random.nextInt()) % 100;
            String image="/page/images/m"+i+".png";
            String  statdate= DateUtil.date2Str(new Date(),"yyyy-MM-dd HH:mm:ss");
            String weight=2+i+"寸";

            System.out.println("insert into product(pname,price,color,image,statdate,weight) " +
                    "values (\""+pname+"\","+price+",\""+color+"\",\""+image+"\",\""+statdate+"\",\""+weight+"\");");
        }


    }
}
