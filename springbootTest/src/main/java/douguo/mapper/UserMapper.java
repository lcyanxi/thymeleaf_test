package douguo.mapper;

import douguo.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by lcyanxi on 2018/2/26.
 */
@Mapper
@CacheConfig(cacheNames = "users")
public interface UserMapper {

    int  getCount();

    @Cacheable(key ="#p0")
    List<UserEntity> getAll(@Param("start") int start,@Param("length") int length);

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    @CachePut(key = "#p0")
    void update(UserEntity user);

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key ="#p0",allEntries=true)
    void delete(Long id);
}
