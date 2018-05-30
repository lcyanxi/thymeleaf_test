package douguo.mapper;

import douguo.model.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper {

    void addProductToMyCart(Cart cart);
    List<Cart> selectAllProductByUid(int uid);
    Cart selectCartByCid(int cid);
    void updateCartNum(@Param("cid") int cid,@Param("num") int num,@Param("totalPrice") double totalPrice);

    void deleteProdutFromCartByCid(int cid);
    void deleteAll(int uid);

    int CountCartNumByUid(int uid);
}
