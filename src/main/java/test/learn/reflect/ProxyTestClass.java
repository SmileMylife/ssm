package test.learn.reflect;

import com.store.common.InputObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by ZhangPei on 2018/7/31.
 */
public class ProxyTestClass {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.store.common.InputObject");
        Object o = aClass.newInstance();
        if (o instanceof InputObject) {
            System.out.println("o是inputobje的实例");
            InputObject inputObject = (InputObject) o;
            HashMap<String, Object> params = inputObject.getParams();
            System.out.println(params.toString());
        }
        IProxyInterface iProxyInterface = new ProxyInterfaceServiceImpl2();

        proxyMethod(iProxyInterface);

    }

    public static void proxyMethod(IProxyInterface iProxyInterface) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<? extends IProxyInterface> aClass = iProxyInterface.getClass();
        Method[] methods = aClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().equals("sleep")) {
                System.out.println("有sleep方法");
                IProxyInterface iProxyInterface1 = aClass.newInstance();
                methods[i].invoke(iProxyInterface1, null);
            }
        }

    }
}
