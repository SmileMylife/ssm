package test.jdkproxy.scene2.impl;

import test.jdkproxy.scene2.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by ZhangPei on 2018/6/28.
 */
public class PersonProxyImpl implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //以上参数提供了代理对象及对象拥有的方法及参数
        if ("sleep".equals(method.getName())) {
            System.out.println("执行的方法是睡觉");
        }
        return null;
    }
}
