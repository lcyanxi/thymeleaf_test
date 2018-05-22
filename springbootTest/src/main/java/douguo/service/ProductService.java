package douguo.service;

import douguo.mapper.ProductMapper;
import douguo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService {

    @Autowired
    private ProductMapper productMapper;


    public void addProduct(Product product){
         productMapper.addProduct(product);
    }
}
