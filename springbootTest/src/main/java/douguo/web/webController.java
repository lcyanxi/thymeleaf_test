package douguo.web;

import douguo.model.Info;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcyanxi on 2018/2/14.
 */
@Controller public class webController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET) public String hello(Model model) {
        model.addAttribute("name", "Dear");
        return "home";
    }

    @RequestMapping(value = "/tableDemoAjax",method = RequestMethod.POST)
    @ResponseBody
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

        // 生成20条测试数据，在实际开发中这里的数据应该是根据分页、排序、查询等情况从数据库中进行查询的
        List<String[]> lst = new ArrayList<String[]>();
        List<Info> list=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Info info=new Info();
            info.setAddress("address"+i);
            info.setFirstname("firstname"+i);
            info.setLastname("lastname"+i);
            info.setId(i);
            list.add(info);
        }

        JSONObject getObj = new JSONObject();
        System.out.println("sEcho:"+sEcho);
        System.out.println("iDisplayStart"+iDisplayStart+":iDisplayStart+iDisplayLength"+iDisplayStart+iDisplayLength);
        getObj.put("sEcho", sEcho);
        getObj.put("iTotalRecords", list.size());          //实际的行数
        getObj.put("iTotalDisplayRecords", list.size());   //显示的行数,这个要和上面写的一样
        getObj.put("aaData", list.subList(iDisplayStart,iDisplayStart+iDisplayLength));//要以JSON格式返回，否则前台没法显示
        System.out.println(getObj);
        return getObj.toString();
    }


}
