package douguo.service;

import douguo.mapper.ProductMapper;
import douguo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductService {

    @Autowired
    private ProductMapper productMapper;


    public void addProduct(Product product){
         productMapper.addProduct(product);
    }

    public List<Product> findAllProduct(){
        return  productMapper.findAllProductList();
    }

    public int deleteProductById(int pid){
        return productMapper.deleteProductById(pid);
    }

    public Product findProductByPid(int pid){
        return  productMapper.findProductByPid(pid);
    }
}
