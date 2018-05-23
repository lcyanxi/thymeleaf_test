package douguo.mapper;

import douguo.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

     void   addProduct(Product product);

     List<Product>   findAllProductList();

     Product findProductByPid(int pid);


     int deleteProductById(int pid);

}
