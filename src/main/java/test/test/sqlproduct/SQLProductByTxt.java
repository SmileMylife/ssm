package test.test.sqlproduct;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ZhangPei on 2018/10/16.
 */
public class SQLProductByTxt {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader("/Users/smile_mylife/Desktop/id.txt"));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/Users/smile_mylife/Desktop/name.txt"));
        String line1 = "";
        String line2 = "";
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        while ((line1 = bufferedReader1.readLine()) != null) {
            list1.add(line1);
        }
        bufferedReader1.close();

        while ((line2 = bufferedReader2.readLine()) != null) {
            list2.add(line2);
        }
        bufferedReader2.close();

        String start = "18101616023";
        int startNum = 30146001;
        for (int i = 0; i < list1.size(); i++) {
            String id = list1.get(i);
            String name = list2.get(i);
            ++ startNum;
            String sql = "INSERT INTO `t_sr_cfg_code`(`TENANT_ID`, `PROV_CODE`, `CODE_ID`, `CODE_TYPE_CD`, `CODE_NM`, `CODE_FULL_NM`, `ARGE_SEQNO`, `LEAF_NODE_FLAG`, `VALID_FLAG`, `RMK`, `ORG_BRNCH_ID`, `OP_STAFF_ID`, `CRT_TIME`, `MODF_TIME`, `BIZ_CODE`, `SUPR_BIZ_CODE`, `CODE_TYPE_NM`, `cmos_modify_time`) VALUES ('100000', '00030025'," + (start + startNum) + ", 'COMMON_CODE@AFORM_OBJECT_TYPE', '" + name + "', '" + name + "', 1, 1, 1, '', '000300070016', 'JLT0001', '2018-09-08 11:33:20', '2018-09-08 11:33:20', '" + id + "', '01', 'AMS派发对象', '2018-10-16 17:17:05.910');";
            System.out.println(sql);
            System.out.println();
        }
    }
}
