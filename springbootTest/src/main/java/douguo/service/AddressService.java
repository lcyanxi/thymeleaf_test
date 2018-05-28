package douguo.service;

import douguo.mapper.AddressMapper;
import douguo.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lcyanxi on 2018/5/28.
 */
@Service
public class AddressService {
    @Autowired
    private AddressMapper addressMapper;

    public void addAddress(Address address) throws Exception{
        addressMapper.addAddress(address);
    }

    public List<Address> selectAllAddressByUid(int uid){
        return addressMapper.selectAllAddressByUid(uid);
    }
}
