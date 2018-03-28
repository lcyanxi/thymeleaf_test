import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

/**
 * Created by lichang on 2018/3/8
 */
public final class IPUnMasker extends UDF {
    /**
     * 将ip转换为二进制
     * @param s
     * @return
     */
    public Text evaluate(final Text s) {
        if (s == null) { return null; }

        StringBuilder ret = new StringBuilder();

        String[] items = s.toString().split("\\.");
        if (items.length != 4)
            return null;

        for (String item : items) {
            StringBuilder sb = new StringBuilder();
            int a = Integer.parseInt(item);
            for (int i=0; i<8; i++) {
                sb.insert(0, a%2);
                a = a/2;
            }
            ret.append(sb);
        }

        return new Text(ret.toString());
    }

    public static void main(String[] args) {
        String ip = "192.168.2.175";
        IPUnMasker unmasker = new IPUnMasker();
        System.out.println(unmasker.evaluate(new Text(ip)));
    }
}

