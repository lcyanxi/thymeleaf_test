package douguo.mapper;

import douguo.model.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lcyanxi on 2018/2/26.
 */
public interface UserMapper {
    int  getCount();

    List<UserEntity> getAll(@Param("start") int start,@Param("length") int length);

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);
}
