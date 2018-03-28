package douguo.web;

import douguo.bean.User;
import douguo.service.UserService;
import douguo.util.ToolRandoms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created by lichang on 2018/3/8
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam String username,@RequestParam String nickname,@RequestParam String email,
        @RequestParam String password, String sex){
        User user=new User();
        user.setId(Integer.parseInt(ToolRandoms.randomCode8()));
        user.setUsername(username);
        user.setNickname(nickname);
        user.setPassword(password);
        user.setEmail(email);
        user.setSex(sex);
        user.setRegisterTime(new Date());

        System.out.println(user);
        userService.register(user);



        return "pages/index";
    }
}
