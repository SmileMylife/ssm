package test.dbswitch;

/**
 * Created by ZhangPei on 2018/8/9.
 */
public class DataSourceHandle {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    //获取省份编码
    public static String getDbKey() {
        return threadLocal.get();
    }

    //设置省份编码
    public static void setDbKey(String dbKey) {
        threadLocal.set(dbKey);
    }

    //删除当前数据源
    public static void removeDbKey() {
        threadLocal.remove();
    }
}
