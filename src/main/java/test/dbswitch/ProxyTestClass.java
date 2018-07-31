package test.dbswitch;

import com.store.common.InputObject;

/**
 * Created by ZhangPei on 2018/7/31.
 */
public class ProxyTestClass {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("com.store.common.InputObject");
        Object o = aClass.newInstance();
        if (o instanceof InputObject) {
            System.out.println("o是inputobje的实例");
        }
    }
}
