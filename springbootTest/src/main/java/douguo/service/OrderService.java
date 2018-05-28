package douguo.service;

import douguo.mapper.CartMapper;
import douguo.mapper.OrderMapper;
import douguo.mapper.ProductMapper;
import douguo.model.Cart;
import douguo.model.OrderDetailInfo;
import douguo.model.OrderInfo;
import douguo.model.Product;
import douguo.util.DateUtil;
import douguo.util.ToolRandoms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    public List<Cart> findAllProductByCid(String []  cartids){
        List<Cart>  cartList=new ArrayList<>();
        for (String cid:cartids){
            Cart cart=cartMapper.selectCartByCid(Integer.parseInt(cid));
            Product product=productMapper.findProductByPid(cart.getPid());
            cart.setPrice(product.getPrice());
            cart.setPname(product.getPname());
            cart.setImage(product.getImage());
            cartList.add(cart);
        }

      return cartList;
    }



    @Transient
    public OrderInfo createOrder(int uid,String aid,String cids[]) throws Exception{
        double totalPrice=0.0;
        String orderId=ToolRandoms.randomCode8();
        for (String cid:cids){
            Cart cart=cartMapper.selectCartByCid(Integer.parseInt(cid));

            OrderDetailInfo detailInfo=new OrderDetailInfo();
            detailInfo.setNum(cart.getNum());
            detailInfo.setOid(orderId);
            detailInfo.setPid(cart.getPid());
            System.out.println(detailInfo);
            orderMapper.addOderDetailInfo(detailInfo);
            totalPrice=totalPrice+cart.getTotalPrice();
        }
        OrderInfo orderInfo=new OrderInfo();
        orderInfo.setOid(orderId);
        orderInfo.setAid(Integer.parseInt(aid));
        orderInfo.setUid(uid);
        orderInfo.setTotalPrice(totalPrice);
        orderInfo.setPayMak(0);
        orderInfo.setCreateTime(DateUtil.date2Str(new Date(),"yyyy-MM-dd HH:mm:ss"));

        orderMapper.addOderInfo(orderInfo);


        return orderInfo;

    }
}
