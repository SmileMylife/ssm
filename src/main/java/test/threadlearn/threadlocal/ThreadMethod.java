package test.threadlearn.threadlocal;

import java.util.Map;

/**
 * Created by ZhangPei on 2018/11/8.
 */
public class ThreadMethod implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("当前线程名称为" + name);
    }
}
