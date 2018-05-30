package douguo.model;

import java.util.List;

/**
 * Created by lcyanxi on 2018/5/28.
 */
public class OrderDetailInfo {
    private int id;
    private String oid;
    private int pid;
    private int num;

    private List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderDetailInfo{" +
                "id=" + id +
                ", oid='" + oid + '\'' +
                ", pid=" + pid +
                ", num=" + num +
                '}';
    }
}
