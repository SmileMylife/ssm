package test.task;

import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ZhangPei on 2018/8/1.
 */
@Service
public class AutoSendTask {
    public void autoSend() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 5, 300, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        System.out.println(threadPoolExecutor.getPoolSize());
    }
}
