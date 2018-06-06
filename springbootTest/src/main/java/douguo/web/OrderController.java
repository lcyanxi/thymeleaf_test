package douguo.web;

import douguo.model.Address;
import douguo.model.Cart;
import douguo.model.OrderInfo;
import douguo.model.User;
import douguo.service.AddressService;
import douguo.service.OrderService;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static douguo.util.constent.MESSAGE;
import static douguo.util.constent.STATUS;

@Controller
@RequestMapping("/order")
public class OrderController extends CommonController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private AddressService addressService;


    @RequestMapping(value = "/indent", method = RequestMethod.POST)
    public String toIndentPage(Model model, @RequestParam(value = "cartid", required = false) String[] cartids) {

        System.out.println(cartids);
        if (cartids==null||cartids.equals("")){
            return "forward:/cart/myCart";
        }
        User user = (User) session.getAttribute("user");
        List<Cart> list = orderService.findAllProductByCid(cartids);
        double moneys = 0;
        for (Cart cart : list) {
            moneys = moneys + cart.getTotalPrice();
        }
        List<Address> addressList = addressService.selectAllAddressByUid(user.getUid());
        model.addAttribute("list", list);
        model.addAttribute("addList", addressList);
        model.addAttribute("moneys", moneys);

        return "pages/indent";
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public String createOrder(@RequestParam(value = "aid") String aid,
                              @RequestParam(value = "cid") String[] cids,
                              Model model) {

        User user = (User) session.getAttribute("user");
        try {
            OrderInfo orderInfo = orderService.createOrder(user.getUid(), aid, cids);
            model.addAttribute("order", orderInfo);
        } catch (Exception e) {

            e.printStackTrace();
            return "forward:order/indent";
        }

        return "pages/order";
    }

    @RequestMapping(value = "/payment/{oid}", method = RequestMethod.GET)
    public String ToPayMent(@PathVariable(value = "oid") String oid) {

        try {
            orderService.toPayMent(oid);
        } catch (Exception e) {
            e.printStackTrace();

            return "pages/order";
        }
        return "forward:/order/showOrderInfo";

    }

    @RequestMapping(value = "/toPayment", method = RequestMethod.GET)
    @ResponseBody
    public Map payment(String oid) {
        System.out.println(oid);
        Map map=new HashMap();
        try {
            orderService.toPayMent(oid);
            map.put(STATUS, 1);
            map.put(MESSAGE, "支付成功！！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put(STATUS, 0);
            map.put(MESSAGE, "支付失败！！");
        }

        return map;
    }

    @RequestMapping(value = "/deleteOrder", method = RequestMethod.GET)
    @ResponseBody
    public Map deleteOrder(@RequestParam(value = "oid") String oid) {
        Map map=new HashMap();
       int id= orderService.deleteOrderByOid(oid);
        System.out.println(id);
            if (id>0){
                map.put(STATUS, 1);
                map.put(MESSAGE, "删除成功！！");
            }else {
                map.put(STATUS, 0);
                map.put(MESSAGE, "删除失败！！");
            }
        return map;

    }

    @RequestMapping(value = "/showOrderInfo", method = RequestMethod.GET)
    public String toShowOrderList(Model model) {
        User user = (User) session.getAttribute("user");

        List list=orderService.selectAllOrderByUid(user.getUid());

        model.addAttribute("list",list);
        return "pages/showOrderInfo";
    }

    @RequestMapping(value = "/manageOrder", method = RequestMethod.GET)
    public String toManageOrder(Model model) {
        List list=orderService.selectAllOrder();

        model.addAttribute("list",list);
        return "manage_order";
    }

    @RequestMapping(value = "/manage/{oid}", method = RequestMethod.GET)
    public String manage(@PathVariable(value = "oid") String oid) {
       orderService.manage(oid);
        return "forward:/order/manageOrder";
    }
}
