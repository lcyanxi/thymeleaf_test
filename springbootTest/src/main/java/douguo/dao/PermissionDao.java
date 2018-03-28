package douguo.dao;

import douguo.bean.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by lichang on 2018/3/5
 */
@Mapper
public interface PermissionDao {
    List<Permission> getByMap(Map<String, Object> map);

    Permission getById(Integer id);

    Integer create(Permission permission);

    int update(Permission permission);

    List<Permission> getByUserId(int userId);
}
