package douguo.web;


import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommonController {
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    protected HttpSession session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;

 /*       //得到当前用户的 Subject
        subject = SecurityUtils.getSubject();
        session = subject.getSession();*/
        session=request.getSession();
    }
}
