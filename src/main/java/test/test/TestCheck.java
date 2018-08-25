package test.test;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by ZhangPei on 2018/7/12.
 */
public class TestCheck {
    public static void main(String[] args) throws Exception {
        String name = checkAcceptStaff(null, "张三是坏人", 20);
        System.out.println(name);

        testJudge("", "1232131", "12321312");
    }

    public static String checkAcceptStaff(String id, String name,int lenth) {
        String nameNew = name;
        if (StringUtils.isNotBlank(nameNew) && nameNew.contains("|")) {
            nameNew = nameNew.substring(0, nameNew.indexOf('|'));
        }
        String str = id + "-" + nameNew;
        int length = lenth;
        if (StringUtils.isNotBlank(id)) {
            if (id.length() > length) {
                str = id.substring(0, length);
            } else {
                if (str.getBytes().length > ++length) {
                    int len = (length - id.getBytes().length) / 3;
                    nameNew = str.substring(id.length(), len + id.length());
                    str = id + nameNew;
                }
            }
        }
        return str;
    }

    public static void testJudge(String provCode, String wrkfmId, String srvReqstId) throws Exception {
        if (org.apache.commons.lang.StringUtils.isBlank(provCode) || (org.apache.commons.lang.StringUtils.isBlank(wrkfmId) && org.apache.commons.lang.StringUtils.isBlank(srvReqstId))) {
            throw new Exception("搬表失败，省份编码或工单ID或服务请求ID为空");
        }
    }
}
