package test.test;

import java.math.BigInteger;

/**
 * Created by ZhangPei on 2018/11/1.
 */
public class ProductSQL {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("1811011043330146001");
        for (int i = 1; i <= 31; i++) {
            String sql = "INSERT INTO `t_sr_cfg_code`(`TENANT_ID`, `PROV_CODE`, `CODE_ID`, `CODE_TYPE_CD`, `CODE_NM`, `CODE_FULL_NM`, `ARGE_SEQNO`, `LEAF_NODE_FLAG`, `VALID_FLAG`, `RMK`, `ORG_BRNCH_ID`, `OP_STAFF_ID`, `CRT_TIME`, `MODF_TIME`, `BIZ_CODE`, `SUPR_BIZ_CODE`, `CODE_TYPE_NM`, `cmos_modify_time`) VALUES ('100000', {provCode}, {codeId}, 'COMMON_CODE@RULE_TYPE_04', '归属省份', '归属省份', 2, 1, 1, '归属省份', '001016', 'YX1000', '2018-10-23 17:04:10', '2018-10-23 17:04:16', 'acptNumBelgProvCode', '0', '归属省份', '2018-10-24 17:39:41.156');";
            if (i < 10) {
                String result = sql.replace("{provCode}", "'0003000" + i + "'").replace("{codeId}", bigInteger + "");
                System.out.println(result);
                System.out.println();
            } else {
                String result = sql.replace("{provCode}", "'000300" + i + "'").replace("{codeId}", bigInteger + "");
                System.out.println(result);
                System.out.println();
            }
            bigInteger = bigInteger.add(new BigInteger("1"));
        }


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        //生成回滚脚本
        BigInteger bigInteger1 = new BigInteger("1811011043330146001");

        for (int i = 1; i <= 31; i++) {
            String sql = "DELETE FROM T_SR_CFG_CODE WHERE CODE_ID = ?;";
            String replace = sql.replace("?", bigInteger1 + "");
            System.out.println(replace);
            System.out.println();
            bigInteger1 = bigInteger1.add(new BigInteger("1"));
        }
    }
}
