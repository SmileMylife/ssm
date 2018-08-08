package test.threadlearn;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ZhangPei on 2018/7/31.
 */
public class ThreadTestClass {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        AutoSendThread autoSendThread;
        for (int i = 0; i < 100; i++) {
            autoSendThread = new AutoSendThread();
            threadPoolExecutor.execute(autoSendThread);
            System.out.println("当前线程池大小：" + threadPoolExecutor.getPoolSize() + "队列中等待执行的任务：" + threadPoolExecutor.getQueue().size() + "已经执行完毕的线程数量：" + threadPoolExecutor.getCompletedTaskCount());
        }
        threadPoolExecutor.shutdown();
    }
}
