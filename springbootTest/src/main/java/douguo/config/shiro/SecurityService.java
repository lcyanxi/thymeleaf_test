package douguo.config.shiro;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lichang on 2018/3/8
 */
@Service
public class SecurityService  {
    /**
     * 加密的算法
     */
    public static String ENCODE_ALGORITHM_NAME = "md5";

    /**
     * 哈希 迭代加密次数
     */
    public static int ENCODE_HASH_ITERATION = 3;

    /**
     * 加密过后的密码的key
     */
    public static String ENCODE_RESULT_KEY_PASSWORD = "password";

    /**
     * 用户生成哈希值 的摘要
     */
    public static String ENCODE_RESULT_KEY_SALT = "salt";

    /**
     * 随机声生成后半 摘要
     */
    private SecureRandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();


    public Map<String, String> encodePassword(String password, String preSalt) {

        //后半 摘要
        String subSalt = randomNumberGenerator.nextBytes().toHex();
        String salt = preSalt + subSalt;

        //生成
        SimpleHash simpleHash = new SimpleHash(ENCODE_ALGORITHM_NAME, password, salt, ENCODE_HASH_ITERATION);
        String encodePassword = simpleHash.toHex();

        //返回 生成的   和 摘要
        Map<String, String> map = new HashMap<>();
        map.put(ENCODE_RESULT_KEY_PASSWORD, encodePassword);
        map.put(ENCODE_RESULT_KEY_SALT, subSalt);

        return map;
    }
}
