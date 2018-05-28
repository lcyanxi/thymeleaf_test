package douguo.model;

/**
 * Created by lcyanxi on 2018/5/28.
 */
public class OrderInfo {
    private String oid;
    private int uid;
    private int aid;
    private String createTime;
    private double totalPrice;
    private int payMak;
    private int flag;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getPayMak() {
        return payMak;
    }

    public void setPayMak(int payMak) {
        this.payMak = payMak;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", aid=" + aid +
                ", createTime='" + createTime + '\'' +
                ", totalPrice=" + totalPrice +
                ", payMak=" + payMak +
                ", flag=" + flag +
                '}';
    }
}
