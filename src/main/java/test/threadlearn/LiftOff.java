package test.threadlearn;

/**
 * Created by ZhangPei on 2018/8/13.
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;   //初始计时，默认10s
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {

    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "liftOff") + ").";
    }

    @Override
    public void run() {
        while (countDown -- > 0) {
            taskCount = countDown;
            System.out.println(id);
            System.out.println(status());
            Thread.yield();
        }
    }
}
