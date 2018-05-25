package douguo.service;

import douguo.mapper.CartMapper;
import douguo.mapper.ProductMapper;
import douguo.model.Cart;
import douguo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

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
}
