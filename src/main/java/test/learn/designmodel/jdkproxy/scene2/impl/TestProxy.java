package test.learn.designmodel.jdkproxy.scene2.impl;

import test.learn.designmodel.jdkproxy.scene2.Person;

import java.lang.reflect.Proxy;

/**
 * Created by ZhangPei on 2018/6/28.
 */
public class TestProxy {
    public static void main(String[] args) {
        Person person = (Person) Proxy.newProxyInstance(TestProxy.class.getClassLoader(), new Class[]{Person.class}, new PersonProxyImpl());
        person.sleep();

    }
}
