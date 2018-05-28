package douguo.mapper;

import douguo.model.OrderDetailInfo;
import douguo.model.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    void addOderInfo(OrderInfo orderInfo);
    void addOderDetailInfo(OrderDetailInfo orderDetailInfo);

}
