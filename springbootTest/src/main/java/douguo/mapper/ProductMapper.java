package douguo.mapper;

import douguo.model.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

     void   addProduct(Product product);
}
