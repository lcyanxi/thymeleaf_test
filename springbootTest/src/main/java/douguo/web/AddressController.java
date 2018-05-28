package douguo.web;

import douguo.model.Address;
import douguo.model.User;
import douguo.service.AddressService;
import douguo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static douguo.util.constent.MESSAGE;
import static douguo.util.constent.STATUS;

/**
 * Created by lcyanxi on 2018/5/28.
 */
@Controller
@RequestMapping("/address")
public class AddressController extends CommonController {

    @Autowired
    private AddressService addressService;




    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    @ResponseBody
    public Map addAddress(String addName, String address, String detailAddress, String phone) {
        Map map = new HashMap();

        User user = (User) session.getAttribute("user");

        Address add = new Address();
        add.setUid(user.getUid());
        add.setAddName(addName);
        add.setAddress(address);
        add.setDetailAddress(detailAddress);
        add.setPhone(phone);
        add.setCreateTime(DateUtil.date2Str(new Date(),"yyyy-MM-dd HH:mm:ss"));
        add.setFlag(1);
        try {
            addressService.addAddress(add);
            map.put(STATUS, 1);
            map.put(MESSAGE, "联系人信息保存成功！！");
        }catch (Exception e){
            map.put(STATUS, 0);
            map.put(MESSAGE, "联系人信息保存失败！！");
        }

        return map;
    }
}
