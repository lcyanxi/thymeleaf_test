package douguo.mapper;

import douguo.model.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {

    void addProductToMyCart(Cart cart);
    List<Cart> selectAllProductByUid(int uid);
}
