package douguo.service;

import douguo.mapper.AddressMapper;
import douguo.mapper.CartMapper;
import douguo.mapper.OrderMapper;
import douguo.mapper.ProductMapper;
import douguo.model.*;
import douguo.util.DateUtil;
import douguo.util.ToolRandoms;
import douguo.vo.Products;
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

    @Autowired
    private AddressMapper addressMapper;

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

    public void toPayMent(String oid) throws Exception{
        orderMapper.toPayMent(oid);
    }

    public List selectAllOrderByUid(int uid){
        List<OrderInfo>  orderInfos=orderMapper.selectAllOrderByUid(uid);
        List<ShowOrderInfos> showOrderInfosList=new ArrayList<>();

        for (OrderInfo orderInfo:orderInfos){
            ShowOrderInfos showOrderInfos=new ShowOrderInfos();
            showOrderInfos.setOid(orderInfo.getOid());
            showOrderInfos.setTotalPrice(orderInfo.getTotalPrice());
            showOrderInfos.setPaymak(orderInfo.getPayMak());
            showOrderInfos.setCreateTime(orderInfo.getCreateTime());

            Address address=addressMapper.selectAddressByAid(orderInfo.getAid());
            showOrderInfos.setAddName(address.getAddName());

            List<OrderDetailInfo>  orderDetailInfos=orderMapper.selectAllOrderByOid(orderInfo.getOid());
            List<Products> productsList=new ArrayList<>();
            for (OrderDetailInfo orderDetailInfo:orderDetailInfos){
                Products products=new Products();
                products.setNum(orderDetailInfo.getNum());
                Product product=productMapper.findProductByPid(orderDetailInfo.getPid());
                products.setImage(product.getImage());
                products.setPname(product.getPname());
                productsList.add(products);
            }
            showOrderInfos.setProducts(productsList);
            showOrderInfosList.add(showOrderInfos);
        }
        return  showOrderInfosList;
    }

    public List selectAllOrder(){
        List<OrderInfo>  orderInfos=orderMapper.selectAllOrder();
        List<ShowOrderInfos> showOrderInfosList=new ArrayList<>();

        for (OrderInfo orderInfo:orderInfos){
            ShowOrderInfos showOrderInfos=new ShowOrderInfos();
            showOrderInfos.setOid(orderInfo.getOid());
            showOrderInfos.setTotalPrice(orderInfo.getTotalPrice());
            showOrderInfos.setPaymak(orderInfo.getPayMak());
            showOrderInfos.setCreateTime(orderInfo.getCreateTime());
            showOrderInfos.setFlag(orderInfo.getFlag());

            Address address=addressMapper.selectAddressByAid(orderInfo.getAid());
            showOrderInfos.setAddName(address.getAddName());

            List<OrderDetailInfo>  orderDetailInfos=orderMapper.selectAllOrderByOid(orderInfo.getOid());
            List<Products> productsList=new ArrayList<>();
            for (OrderDetailInfo orderDetailInfo:orderDetailInfos){
                Products products=new Products();
                products.setNum(orderDetailInfo.getNum());
                Product product=productMapper.findProductByPid(orderDetailInfo.getPid());
                products.setImage(product.getImage());
                products.setPname(product.getPname());
                productsList.add(products);
            }
            showOrderInfos.setProducts(productsList);
            showOrderInfosList.add(showOrderInfos);
        }
        return  showOrderInfosList;
    }

    @Transient
    public int deleteOrderByOid(String oid){
        orderMapper.deleteOrderDetailByOid(oid);
       return orderMapper.deleteOrder(oid);
    }

    @Transient
    public int manage(String oid){
        return  orderMapper.manage(oid);
    }
}
