package douguo.dao;

import douguo.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by lichang on 2018/3/5
 */
@Mapper
public interface UserDao {
    List<User> getByMap(Map<String, Object> map);
    User getById(Integer id);
    Integer create(User user);
    int update(User user);
    int delete(Integer id);
    User getByUserName(String userName);
}
