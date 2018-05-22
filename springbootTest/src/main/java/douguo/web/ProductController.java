package douguo.web;

import douguo.model.Product;
import douguo.service.ProductService;
import douguo.util.DateUtil;
import douguo.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.dc.pr.PRError;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static douguo.util.constent.IMAGEUPLOADPATH;
import static douguo.util.constent.MESSAGE;
import static douguo.util.constent.STATUS;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/toManageProduct",method = RequestMethod.GET)
    public String toManageProductPage(){
        return "manage_product";
    }


    @RequestMapping(value = "/add_product",method = RequestMethod.POST)
    @ResponseBody
    public Map addProduct(@RequestParam(value = "image") MultipartFile image,
                          @RequestParam(value = "pname") String pname,
                          @RequestParam(value = "price") String price,
                          @RequestParam(value = "color") String color,
                          @RequestParam(value = "weight") String weight){
        Map map=new HashMap();

        try {
            //把头像存在文件夹里  数据库存头像的地址
            String imageName = FileUploadUtil.uploadHeadImage(IMAGEUPLOADPATH,image);
            if (imageName != null) {    //判断文件是否存在文件夹里
                Product product=new Product();
                product.setPname(pname);
                product.setPrice(Double.valueOf(price));
                product.setColor(color);
                product.setWeight(weight);
                product.setImage(imageName);
                product.setStatdate(DateUtil.date2Str(new Date(),"yyyy-MM-dd HH:mm:ss"));
                product.setFlag(1);
                productService.addProduct(product);

                map.put(STATUS, true);
                return map;
            }
        } catch (IOException e) {
            map.put(STATUS, false);
            map.put(MESSAGE, "文件写入失败！！");
        }

        return map;
    }
}
