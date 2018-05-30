package douguo.model;

import douguo.vo.Products;

import java.util.List;

/**
 * Created by lcyanxi on 2018/5/29.
 */
public class ShowOrderInfos {
    private String oid;
    private int num;
    private String image;
    private String createTime;
    private String addName;
    private double totalPrice;
    private int paymak;
    private List<Products> products;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getPaymak() {
        return paymak;
    }

    public void setPaymak(int paymak) {
        this.paymak = paymak;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
