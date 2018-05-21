package douguo.web;

import douguo.util.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static douguo.util.constent.IMAGEUPLOADPATH;
import static douguo.util.constent.MESSAGE;
import static douguo.util.constent.STATUS;

@Controller
@RequestMapping("/product")
public class ProductController {

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
        System.out.println(image);
        System.out.println(pname+price+color+weight);

        try {
            //把头像存在文件夹里  数据库存头像的地址
            String savatorPath = FileUploadUtil.uploadHeadImage(IMAGEUPLOADPATH,image);
            System.out.println("savatorPath:" + savatorPath);
            if (savatorPath != null) {    //判断文件是否存在文件夹里
                //判断数据库是否更新了头像路劲
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
