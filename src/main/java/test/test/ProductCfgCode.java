package test.test;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangPei on 2018/10/24.
 */
public class ProductCfgCode {
    public static void main(String[] args) throws IOException {
        BigInteger bigInteger = new BigInteger("1810241610330146001");
        int start = 3215;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/Users/smile_mylife/Desktop/脚本.txt")));
        String s = "";
        List<String> list = new ArrayList<String>();
        while (StringUtils.isNotBlank(s = bufferedReader.readLine())) {
            list.add(s);
        }
        bufferedReader.close();
        if (CollectionUtils.isNotEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                String s1 = list.get(i);
                String replace = s1.replace(start + i + "", bigInteger + "");
                String replace1 = replace.replace("COMMON_CODE@CSVC_PROV_CODE", "COMMON_CODE@THREEBIT_PROV_CODE");
                System.out.println(replace1);
                System.out.println();
                bigInteger = bigInteger.add(new BigInteger("1"));
            }
        }
    }
}
