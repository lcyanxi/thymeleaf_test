package douguo.web;

import douguo.model.Cart;
import douguo.model.User;
import douguo.service.CartService;
import douguo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static douguo.util.constent.MESSAGE;
import static douguo.util.constent.STATUS;

@Controller
@RequestMapping("cart")
public class CartController extends CommonController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/order/create",method = RequestMethod.POST)
    public String  toOrderPage(){

        return "pages/order";

    }
    @RequestMapping(value = "/myCart",method = RequestMethod.GET)
    public String toMyCart(Model model) {
        User user=(User) session.getAttribute("user");
        List<Cart> list=cartService.selectAllCartByUid(user.getUid());
        model.addAttribute("list",list);
        System.out.println(list);
        return "pages/myCart";
    }

    @RequestMapping(value = "/addCart",method = RequestMethod.POST)
    @ResponseBody
    public Map addProductToMyCart(@RequestParam(value = "pid") int pid){
        System.out.println(pid);
       User user =(User) session.getAttribute("user");
        Map map=new HashMap();
        Cart cart=new Cart();
        cart.setUid(user.getUid());
        cart.setPid(pid);
        cart.setCreateTime(DateUtil.date2Str(new Date(),"yyyy-MM-dd HH:mm:ss"));
        cart.setFlag(1);
        if ( cartService.addProductToMyCart(cart)){
            map.put(STATUS, 1);
            map.put(MESSAGE, "成功加入我的购物车！！");
        }else {
            map.put(STATUS, 0);
            map.put(MESSAGE, "添加失败，请重试！！");
        }
        return map;

    }
}
