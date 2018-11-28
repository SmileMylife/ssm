package test.learn.thread;

/**
 * Created by ZhangPei on 2018/8/13.
 */
public class ThreadTestClassDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff(10)).start();
        }
    }
}
