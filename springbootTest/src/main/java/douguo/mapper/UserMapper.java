package douguo.mapper;

import douguo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;


/**
 * Created by lcyanxi on 2018/2/26.
 */
@Mapper
@CacheConfig(cacheNames = "users")
public interface UserMapper {

    @Cacheable(value = "count") int getCount();

    User login(@Param("mobile") String mobile,@Param("password") String password);
    void register(User user);

    User selectUserByMobile(String mobile);

    int editProfile(User user);

    @CachePut(key = "#p0") void update(User user);

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key = "#p0", allEntries = true) void delete(Long id);
}
