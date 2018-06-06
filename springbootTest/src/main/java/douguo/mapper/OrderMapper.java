package douguo.mapper;

import douguo.model.OrderDetailInfo;
import douguo.model.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    void addOderInfo(OrderInfo orderInfo);
    void addOderDetailInfo(OrderDetailInfo orderDetailInfo);
    void toPayMent(String oid);

    int manage(String oid);

    List<OrderInfo> selectAllOrderByUid(int uid);
    List<OrderInfo> selectAllOrder();

    List<OrderDetailInfo> selectAllOrderByOid(String oid);

    int deleteOrder(String oid);
    int deleteOrderDetailByOid(String oid);


}
