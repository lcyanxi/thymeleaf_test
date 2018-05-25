package douguo.web;

import douguo.model.Cart;
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
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/toOrderManage",method = RequestMethod.GET)
    public String toOrderManagePage(){
        return "manage_order";
    }

    @RequestMapping(value = "/indent",method = RequestMethod.POST)
    public String toIndentPage(Model model,@RequestParam(value = "cartid", required = false) String [] cartids){

        List<Cart> list=orderService.findAllProductByCid(cartids);
        double moneys=0;
        for (Cart cart: list){
            moneys=moneys+cart.getTotalPrice();
        }
        System.out.println(list);
        model.addAttribute("list",list);
        model.addAttribute("moneys",moneys);

        return "pages/indent";
    }

}
