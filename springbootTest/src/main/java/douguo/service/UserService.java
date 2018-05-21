package douguo.service;

import douguo.bean.User;
import douguo.dao.UserDao;
import douguo.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by lichang on 2018/3/5
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    //@Autowired
    //private SecurityService securityService;

    public List<User> getByMap(Map<String,Object> map) {
        return userDao.getByMap(map);
    }

    public User getById(Integer id) {
        return userDao.getById(id);
    }

    public User create(User user) {
        userDao.create(user);
        return user;
    }

    public User register(User user){
        user.setPassword(MD5Util.encode(user.getPassword()));
        userDao.create(user);

        return null;
    }

    public User update(User user) {
        userDao.update(user);
        return user;
    }

    public int delete(Integer id) {
        return userDao.delete(id);
    }

    public User getByUserName(String userName) {
        return userDao.getByUserName(userName);
    }
}
