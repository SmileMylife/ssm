package test.test;

/**
 * Created by ZhangPei on 2018/11/1.
 */
public class Test1 {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s + "");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s).append("123");
        System.out.println(stringBuilder.toString());
    }
}
