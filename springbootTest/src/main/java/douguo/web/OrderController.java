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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController  extends  CommonController{

    @Autowired
    private OrderService orderService;
    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/toOrderManage",method = RequestMethod.GET)
    public String toOrderManagePage(){
        return "manage_order";
    }

    @RequestMapping(value = "/indent",method = RequestMethod.POST)
    public String toIndentPage(Model model,@RequestParam(value = "cartid", required = false) String [] cartids){

        User user=(User) session.getAttribute("user");
        List<Cart> list=orderService.findAllProductByCid(cartids);
        double moneys=0;
        for (Cart cart: list){
            moneys=moneys+cart.getTotalPrice();
        }
        List<Address> addressList=addressService.selectAllAddressByUid(user.getUid());
        System.out.println(addressList);
        model.addAttribute("list",list);
        model.addAttribute("addList",addressList);
        model.addAttribute("moneys",moneys);

        return "pages/indent";
    }

    @RequestMapping(value = "/createOrder",method = RequestMethod.POST)
    public String createOrder(@RequestParam(value = "aid") String aid,
                              @RequestParam(value = "cid") String[] cids,
                              Model model){

        User user=(User) session.getAttribute("user");
        try{
            OrderInfo orderInfo=orderService.createOrder(user.getUid(),aid,cids);
            model.addAttribute("order",orderInfo);
        }catch (Exception e){

            e.printStackTrace();
            return "forward:order/indent";
        }

        return "pages/order";
    }

}
