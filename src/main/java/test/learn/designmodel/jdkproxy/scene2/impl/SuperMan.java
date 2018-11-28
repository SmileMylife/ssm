package test.learn.designmodel.jdkproxy.scene2.impl;

import test.learn.designmodel.jdkproxy.scene2.Person;

/**
 * Created by ZhangPei on 2018/6/28.
 */
public class SuperMan implements Person {

    @Override
    public void sleep() {
        System.out.println("超人睡觉");
    }
}
