package douguo.mapper;

import douguo.model.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by lcyanxi on 2018/5/28.
 */
@Mapper
public interface AddressMapper {

    void addAddress(Address address);
    List<Address> selectAllAddressByUid(int uid);
    Address selectAddressByAid(int oid);
}
