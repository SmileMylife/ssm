package test.learn.thread;

import java.util.Map;

/**
 * Created by ZhangPei on 2019/1/29.
 */
public class TestThreadClass implements Runnable {

    public TestThreadClass(Map<String, Object> map) {
        ThreadLocalUtil.set(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.print(ThreadLocalUtil.get());
    }
}
