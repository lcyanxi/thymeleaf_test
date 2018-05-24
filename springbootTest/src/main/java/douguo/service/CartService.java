package douguo.service;

import douguo.mapper.CartMapper;
import douguo.mapper.ProductMapper;
import douguo.model.Cart;
import douguo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;


    public boolean addProductToMyCart(Cart cart){
        try {
            cartMapper.addProductToMyCart(cart);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public List<Cart> selectAllCartByUid(int uid){
        List<Cart> list=cartMapper.selectAllProductByUid(uid);
        for (Cart cart:list){
            Product product=productMapper.findProductByPid(cart.getPid());
            cart.setPname(product.getPname());
            cart.setPrice(product.getPrice());
            cart.setImage(product.getImage());
        }
        return list;
    }
}
