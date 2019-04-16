package test.learn.thread;


/**
 * Created by ZhangPei on 2019/1/29.
 */
public class ThreadLocalUtil {
    public static ThreadLocal threadLocal = new ThreadLocal();

    public static Object get() {
        return threadLocal.get();
    }

    public static void set(Object object) {
        threadLocal.set(object);
    }
}
