package douguo.web;

import douguo.mapper.UserMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcyanxi on 2018/2/14.
 */
@Controller
public class webController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String hello() {
        return "home";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login() {
        return "index";
    }


    @RequestMapping(value = "/toIndent",method = RequestMethod.GET)
    public String toIndentPage() {
        return "pages/indent";
    }


    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String toIndex() {
        return "index";
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String toLogin() {
        return "pages/index";
    }

    @RequestMapping(value = "/permisson",method = RequestMethod.GET)
    public String toPermisson() {
        return "permisson";
    }

    @RequestMapping(value = "/checkout",method = RequestMethod.GET)
    public String toCheckout() {
        return "pages/checkout";
    }

    @RequestMapping(value = "/account",method = RequestMethod.GET)
    public String toAccount() {
        return "pages/account";
    }

    @RequestMapping(value = "/products",method = RequestMethod.GET)
    public String toProducts() {
        return "pages/products";
    }

   // @RequestMapping(value = "/tableDemoAjax",method = RequestMethod.POST)
    //@ResponseBody
    public String tableDemoAjax(@RequestParam String aoData) {
        System.out.println("enter tableDemoAjax");
        System.out.println("aoData--->"+aoData);
        JSONArray jsonarray = JSONArray.fromObject(aoData);
        String sEcho = null;      //记录操作的次数
        int iDisplayStart = 0;    // 起始索引
        int iDisplayLength = 0;   // 每页显示的行数


        //这里获取从前台传递过来的参数，从而确保是否分页、是否进行查询、是否排序等
        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho")){
                sEcho = obj.get("value").toString();
            }

            if (obj.get("name").equals("iDisplayStart")){
                iDisplayStart = obj.getInt("value");
            }

            if (obj.get("name").equals("iDisplayLength")){
                iDisplayLength = obj.getInt("value");
            }
        }

        int totalSize=userMapper.getCount();

        List valueList=new ArrayList();

        JSONObject getObj = new JSONObject();
        System.out.println("sEcho:"+sEcho);
        System.out.println("iDisplayStart"+iDisplayStart+":iDisplayStart+iDisplayLength"+iDisplayStart+iDisplayLength);
        getObj.put("sEcho", sEcho);
        getObj.put("iTotalRecords", totalSize);          //实际的行数
        getObj.put("iTotalDisplayRecords", totalSize);   //显示的行数,这个要和上面写的一样
        getObj.put("aaData", valueList);//要以JSON格式返回，否则前台没法显示
        System.out.println(getObj);
        return getObj.toString();
    }


}
