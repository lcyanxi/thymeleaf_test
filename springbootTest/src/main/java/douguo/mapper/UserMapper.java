package douguo.mapper;

import douguo.model.UserEntity;

import java.util.List;

/**
 * Created by lcyanxi on 2018/2/26.
 */
public interface UserMapper {
    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);
}
