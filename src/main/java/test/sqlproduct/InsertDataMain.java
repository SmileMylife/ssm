package test.sqlproduct;

/**
 * Created by ZhangPei on 2018/8/23.
 */
public class InsertDataMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new InsertDataThread());
        thread.start();
    }
}
