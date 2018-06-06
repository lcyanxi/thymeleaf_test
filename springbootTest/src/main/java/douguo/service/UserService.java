package douguo.service;

import douguo.mapper.UserMapper;
import douguo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by lichang on 2018/3/5
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //@Autowired
    //private SecurityService securityService;


    public void register(User user) throws Exception{
        userMapper.register(user);

    }

    public User selectUserByMobile(String mobile){
        return userMapper.selectUserByMobile(mobile);
    }

    public User login(String mobile,String password){
        return userMapper.login(mobile,password);
    }

    public int editProfile(User user){
     return userMapper.editProfile(user);
    }



}
