package douguo.config.security;

import douguo.bean.Permission;
import douguo.bean.User;
import douguo.dao.PermissionDao;
import douguo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichang on 2018/3/5
 */
@Service
public class UrlUserService implements UserDetailsService {

    @Autowired UserDao userDao;
    @Autowired PermissionDao permissionDao;

    @Override
    public UserDetails loadUserByUsername(String userName) { //重写loadUserByUsername 方法获得 userdetails 类型用户

        User user = userDao.getByUserName(userName);
        if (user != null) {
            List<Permission> permissions;
            permissions = permissionDao.getByUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName()!=null) {
                    GrantedAuthority grantedAuthority = new UrlGrantedAuthority(permission.getPermissionUrl(),permission.getMethod());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            user.setGrantedAuthorities(grantedAuthorities);
            return user;
        } else {
            throw new UsernameNotFoundException("admin: " + userName + " do not exist!");
        }
    }
}
