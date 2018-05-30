package douguo.web;

import douguo.model.Cart;
import douguo.model.User;
import douguo.service.CartService;
import douguo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public Map addProductToMyCart(@RequestParam(value = "pid") int pid,Double price){
        System.out.println(pid);
       User user =(User) session.getAttribute("user");
        Map map=new HashMap();
        Cart cart=new Cart();
        cart.setUid(user.getUid());
        cart.setNum(1);
        cart.setPid(pid);
        cart.setTotalPrice(cart.getNum()*price);
        cart.setCreateTime(DateUtil.date2Str(new Date(),"yyyy-MM-dd HH:mm:ss"));
        cart.setFlag(1);
        if ( cartService.addProductToMyCart(cart)){
            session.setAttribute("num",(int)session.getAttribute("num")+1);
            map.put(STATUS, 1);
            map.put(MESSAGE, "成功加入我的购物车！！");
        }else {
            map.put(STATUS, 0);
            map.put(MESSAGE, "添加失败，请重试！！");
        }
        return map;

    }



    @RequestMapping(value = "/changeProductNum/{cid}", method = RequestMethod.GET)
    public String changeCartProductNum(@PathVariable(value ="cid") int cartid,String type) {
        System.out.println(type);
        //修改数量
        cartService.changeCartNum(type,cartid);

        return "forward:/cart/myCart";
    }


    @RequestMapping(value = "/delete/{cid}", method = RequestMethod.GET)
    public String delete(@PathVariable(value ="cid") int cartid) {
        //修改数量
        cartService.delete(cartid);
        return "forward:/cart/myCart";
    }

    @RequestMapping(value = "/deleteall", method = RequestMethod.GET)
    public String deleteAll() {
        User user=(User) session.getAttribute("user");
        //修改数量
        cartService.deleteAll(user.getUid());
        return "forward:/cart/myCart";
    }

}
