package douguo.web;

import douguo.model.User;
import douguo.service.UserService;
import douguo.util.DateUtil;
import douguo.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static douguo.util.constent.MESSAGE;
import static douguo.util.constent.STATUS;

/**
 * Created by lichang on 2018/3/8
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends CommonController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Map register(@RequestParam String username, @RequestParam String nickname, @RequestParam String email,
                           @RequestParam String password, String mobile, String sex){

        Map map=new HashMap();

        if (userService.selectUserByMobile(mobile)!=null){
            map.put(STATUS,0);
            map.put(MESSAGE,"该电话号码已经注册了");
        }else {

            try {
                User user=new User();
                user.setUsername(username);
                user.setNickname(nickname);
                user.setPassword(MD5Util.encode(password));
                user.setEmail(email);
                user.setMobile(mobile);
                user.setSex(sex);
                user.setRegisterTime(DateUtil.date2Str(new Date(),"yyyy-MM-dd HH:mm:ss"));
                user.setRole("user");
                user.setImage("/img/avatar.jpg");//默认头像
                userService.register(user);
                map.put(STATUS,1);
                map.put(MESSAGE,"注册成功,立即去登录");

            }catch (Exception e){
                map.put(STATUS,0);
                map.put(MESSAGE,"注册失败");
            }
        }
        return map;
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Map login(@RequestParam String mobile,String password){
        Map map=new HashMap();
        password=MD5Util.encode(password);

        System.out.println(mobile+password);
        User user =userService.login(mobile,password);
        if (user!=null){
            session.setAttribute("user",user);
            map.put(STATUS, 1);
            map.put(MESSAGE, "登录成功！！");
        }else {
            map.put(STATUS, 0);
            map.put(MESSAGE, "用户名或者密码不正确！！");
        }
        return map;
    }

    @RequestMapping(value = "/toEditProfile",method = RequestMethod.GET)
    public String toEditProfile(Model model){
        return "pages/editProfile";
    }

    @RequestMapping(value = "/newProfile",method = RequestMethod.GET)
    public String toNewProfile(Model model){
        model.addAttribute("user",session.getAttribute("user"));
        return "pages/profile";
    }
}
