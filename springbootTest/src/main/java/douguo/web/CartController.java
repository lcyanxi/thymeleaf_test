package douguo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {

    @RequestMapping(value = "/order/create",method = RequestMethod.POST)
    public String  toOrderPage(){

        return "pages/order";

    }
}
