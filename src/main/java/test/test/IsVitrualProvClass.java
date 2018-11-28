package test.test;

import java.math.BigInteger;

/**
 * Created by ZhangPei on 2018/11/13.
 */
public class IsVitrualProvClass {
    public static void main(String[] args) {
        //全量划转省份
        String[] arr = {"00030016", "00030014", "00030002", "00030019", "00030027", "00030026", "00030029", "00030012", "00030011", "00030013", "00030005", "00030031", "00030006", "00030004"};
//        String sql = "INSERT INTO `t_sr_cfg_code`(`TENANT_ID`, `PROV_CODE`, `CODE_ID`, `CODE_TYPE_CD`, `CODE_NM`, `CODE_FULL_NM`, `ARGE_SEQNO`, `LEAF_NODE_FLAG`, `VALID_FLAG`, `RMK`, `ORG_BRNCH_ID`, `OP_STAFF_ID`, `CRT_TIME`, `MODF_TIME`, `BIZ_CODE`, `SUPR_BIZ_CODE`, `CODE_TYPE_NM`, `cmos_modify_time`) VALUES ('100000', '{provCode}', {codeId}, 'COMMON_CODE@IS_VITRUAL_PROV', '是否虚拟省份', '是否虚拟省份', 1, 1, 1, '1', '001016', 'YX1000', '2018-11-13 16:08:28', '2018-11-13 16:08:35', '{bizCode}', '0', '是否虚拟省份', '2018-11-13 16:08:51.000');";
        String sql2 = "INSERT INTO `t_sr_cfg_code`(`TENANT_ID`, `PROV_CODE`, `CODE_ID`, `CODE_TYPE_CD`, `CODE_NM`, `CODE_FULL_NM`, `ARGE_SEQNO`, `LEAF_NODE_FLAG`, `VALID_FLAG`, `RMK`, `ORG_BRNCH_ID`, `OP_STAFF_ID`, `CRT_TIME`, `MODF_TIME`, `BIZ_CODE`, `SUPR_BIZ_CODE`, `CODE_TYPE_NM`, `cmos_modify_time`) VALUES ('100000', '{provCode}', {codeId}, 'COMMON_CODE@IS_ALL_PROV', '是否全量划转', '是否全量划转', 1, 1, 1, '1', '001016', 'YX1000', '2018-11-13 16:08:28', '2018-11-13 16:08:35', '{bizCode}', '0', '是否全量划转', '2018-11-13 16:08:51.000');";
        BigInteger bigInteger = new BigInteger("2018111315120146001");
        /*for (int i = 1; i <= 31; i++) {
            String initProv = "000300";
            if (i < 10) {
                initProv += "0" + i;
            } else {
                initProv += i;
            }
            String replace = sql2.replace("{provCode}", initProv).replace("{codeId}", bigInteger.toString()).replace("{bizCode}", "0");
            System.out.println(replace);
            System.out.println();
            bigInteger = bigInteger.add(new BigInteger("1"));
        }*/

        for (int i = 1; i <= 31; i++) {
            boolean flag = false;
            String initProv = "000300";
            if (i < 10) {
                initProv += "0" + i;
            } else {
                initProv += i;
            }
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals(initProv)) {
                    //全量划转
                    String replace = sql2.replace("{provCode}", initProv).replace("{codeId}", bigInteger.toString()).replace("{bizCode}", "1");
                    System.out.println(replace);
                    System.out.println();
                    flag = true;
                    bigInteger = bigInteger.add(new BigInteger("1"));
                }
            }
            if (flag) {
                continue;
            }
            String replace = sql2.replace("{provCode}", initProv).replace("{codeId}", bigInteger.toString()).replace("{bizCode}", "0");
            System.out.println(replace);
            System.out.println();
            bigInteger = bigInteger.add(new BigInteger("1"));
        }

        String lll = "123asdsada123".replace("123", "lll");
        System.out.println(lll);

    }
}
