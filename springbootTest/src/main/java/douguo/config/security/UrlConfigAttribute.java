package douguo.config.security;

import org.springframework.security.access.ConfigAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lichang on 2018/3/5
 */
public class UrlConfigAttribute implements ConfigAttribute {
    private final HttpServletRequest httpServletRequest;

    public UrlConfigAttribute(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }


    @Override
    public String getAttribute() {
        return null;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }
}
