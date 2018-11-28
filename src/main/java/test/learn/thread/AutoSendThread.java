package test.learn.thread;

/**
 * Created by ZhangPei on 2018/7/31.
 */
public class AutoSendThread implements Runnable {

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        int num = 0;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println("执行线程耗时：" +  (end - start));
    }
}
