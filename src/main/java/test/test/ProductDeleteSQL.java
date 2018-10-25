package test.test;

import java.math.BigInteger;

/**
 * Created by ZhangPei on 2018/10/18.
 */
public class ProductDeleteSQL {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("1810241610330146001");
        String sql = "DELETE FROM T_SR_PROC_TEMPLATE_CODE WHERE CODE_ID = ? AND PROV_CODE = '00030016'";
        for (int i = 1; i <= 31; i++) {
            System.out.println(sql.replace("?", bigInteger.toString()));
            bigInteger = bigInteger.add(new BigInteger("1"));
        }
    }
}
