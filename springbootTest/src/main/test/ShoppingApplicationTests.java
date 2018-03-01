import douguo.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichang on 2018/3/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ShoppingApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("v");
        stringRedisTemplate.opsForValue().set("abc", "测试");
        stringRedisTemplate.opsForList().leftPushAll("qq", list); // 向redis存入List
        stringRedisTemplate.opsForList().range("qwe", 0, -1).forEach(value -> {
            System.out.println(value);
        });
    }
}
