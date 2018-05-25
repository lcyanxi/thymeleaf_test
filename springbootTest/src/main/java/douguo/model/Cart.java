package douguo.model;


public class Cart {
    private int cid;
    private int uid;
    private int pid;
    private int num;
    private double totalPrice;
    private String createTime;
    private int flag;

    private String pname;
    private double price;
    private String image;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", num=" + num +
                ", totalPrice=" + totalPrice +
                ", createTime='" + createTime + '\'' +
                ", flag=" + flag +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
