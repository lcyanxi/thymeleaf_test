package douguo.config.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;


/**
 * Created by lichang on 2018/3/5
 */
@Service
public class UrlAccessDecisionManager implements AccessDecisionManager {

    /**
     * 方法是判定是否拥有权限的决策方法
     * @param authentication   CustomUserService中循环添加到 GrantedAuthority 对象中的权限信息集合.
     * @param object  包含客户端发起的请求的requset信息
     * @param configAttributes    为MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法返回的结果，
     *  此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws
        AccessDeniedException, InsufficientAuthenticationException {
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        String url, method;
        if ("anonymousUser".equals(authentication.getPrincipal())
            || matchers("/img/**", request)
            || matchers("/js/**", request)
            || matchers("/css/**", request)
            || matchers("/font/**", request)
            || matchers("/page/**", request)
            || matchers("/", request)
            || matchers("/index.html", request)
            || matchers("/favicon.ico", request)
            || matchers("/index", request)) {
            return;
        } else {
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (ga instanceof UrlGrantedAuthority) {
                    UrlGrantedAuthority urlGrantedAuthority = (UrlGrantedAuthority) ga;
                    url = urlGrantedAuthority.getPermissionUrl();
                    method = urlGrantedAuthority.getMethod();
                    if (matchers(url, request)) {
                        //当权限表权限的method为ALL时表示拥有此路径的所有请求方式权利。
                        if (method.equals(request.getMethod()) || "ALL".equals(method)) {
                            return;
                        }
                    }
                }
            }
        }
        throw new AccessDeniedException("no right");
    }


    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }


    private boolean matchers(String url, HttpServletRequest request) {
        AntPathRequestMatcher matcher = new AntPathRequestMatcher(url);
        if (matcher.matches(request)) {
            return true;
        }
        return false;
    }
}
