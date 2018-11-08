package test.test;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ZhangPei on 2018/11/1.
 */
public class ProductSQLByZhangPei {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/smile_mylife/Desktop/原始数据.txt"));
        String str = "";
        BigInteger bigInteger = new BigInteger("1811011858330146001");

        HashMap<String, String> map = new HashMap<String, String>();
        while ((str = bufferedReader.readLine()) != null) {
            if (StringUtils.isNotBlank(str)) {
                for (int i = 1; i <= 31; i++) {
                    if (i < 10) {
                        String provCode = "0003000" + i;
                        String result = str.replace("{provCode}", "'" + provCode + "'").replace("{codeId}", bigInteger.toString());
                        System.out.println(result);
                        map.put(bigInteger.toString(), provCode);
                        System.out.println();
                    } else {
                        String provCode = "000300" + i;
                        String result = str.replace("{provCode}", "'" + "000300" + i + "'").replace("{codeId}", bigInteger.toString());
                        System.out.println(result);
                        map.put(bigInteger.toString(), provCode);
                        System.out.println();
                    }
                    bigInteger = bigInteger.add(new BigInteger("1"));
                }
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();

        String rollBack = "DELETE FROM T_SR_CFG_CODE WHERE CODE_ID = {codeId};";

        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (Map.Entry<String, String> entry: entries){
            String key = entry.getKey();
            String value = entry.getValue();

            String replace = rollBack.replace("{codeId}", key.toString()).replace("{provCode}", "'" + value + "'");

            System.out.println(replace);
            System.out.println();
        }


    }
}
