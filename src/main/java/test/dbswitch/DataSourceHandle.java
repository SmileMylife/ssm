package test.dbswitch;

import org.springframework.stereotype.Component;

/**
 * Created by ZhangPei on 2018/8/9.
 */
public class DataSourceHandle {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    //获取省份编码
    public static String getProvCode() {
        return threadLocal.get();
    }

    //设置省份编码
    public static void setProvCode(String provCode) {
        threadLocal.set(provCode);
    }
}
