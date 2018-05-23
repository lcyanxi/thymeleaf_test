package douguo.web;

import douguo.model.Product;
import douguo.service.ProductService;
import douguo.util.DateUtil;
import douguo.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.dc.pr.PRError;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
    public String toManageProductPage(Model model){

       List<Product> list= productService.findAllProduct();

       model.addAttribute("data",list);

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
        System.out.println(weight);
        try {
            String imageName = FileUploadUtil.uploadHeadImage(IMAGEUPLOADPATH,image);
            if (imageName != null) {    //判断文件是否存在文件夹里
                Product product=new Product();
                product.setPname(pname);
                product.setPrice(Double.valueOf(price));
                product.setColor(color);
                product.setWeight(weight);
                product.setImage("/upImage/"+imageName);
                product.setStatdate(DateUtil.date2Str(new Date(),"yyyy-MM-dd HH:mm:ss"));
                product.setFlag(1);
                productService.addProduct(product);

                map.put(STATUS, 1);
                map.put(MESSAGE, "添加商品成功！！");
                return map;
            }
        } catch (IOException e) {
            map.put(STATUS, 0);
            map.put(MESSAGE, "添加商品失败！！");
        }

        return map;
    }

    @RequestMapping(value = "/deleteProduct",method = RequestMethod.GET)
    @ResponseBody
    public Map deleteProduct(@RequestParam(value = "pid") int pid){

        Map map=new HashMap();
        if (productService.deleteProductById(pid)>0){
            map.put(STATUS, 1);
            map.put(MESSAGE, "删除商品成功！！");
        }else {
            map.put(STATUS, 0);
            map.put(MESSAGE, "删除商品b失败！！");
        }
        return map;

    }



    @RequestMapping(value = "/showProductList",method = RequestMethod.GET)
    public String showProductList(Model model){
        List<Product> list=productService.findAllProduct();
        model.addAttribute("productList",list);
        return "pages/products";
    }



    @RequestMapping(value = "/showSingle/{pid}",method = RequestMethod.GET)
    public String showSingleProduct(Model model, @PathVariable(value = "pid") int pid){
        Product product=productService.findProductByPid(pid);
        model.addAttribute("product",product);
        return "pages/single";
    }

}
