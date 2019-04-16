package test.learn.thread;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangPei on 2019/1/29.
 */
public class ThreadMainClass {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        /*for (int i = 1; i < 10000; i++) {
            map.put(i + "", "第" + i + "条数据");
            if (i % 1000 == 0) {
                Thread thread = new Thread(new TestThreadClass(map));
                thread.start();
                map.clear();
            }
        }*/
        map.put("username", "zhangpei");

        Thread thread = new Thread(new TestThreadClass(map));
        String s = (String) ThreadLocalUtil.get();
        System.out.println(s);
        thread.start();

    }
}
