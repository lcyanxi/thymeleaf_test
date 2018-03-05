package douguo.service;

import douguo.bean.User;
import douguo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;

/**
 * Created by lichang on 2018/3/5
 */
@Service
public class UserService {
    @Autowired
    private SessionRegistry sessionRegistry;

    @Autowired
    private UserDao userDao;

    public User getById(Integer id) {
        User user = userDao.getById(id);
        return user;
    }
}
