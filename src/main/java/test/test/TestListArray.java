package test.test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by ZhangPei on 2018/8/24.
 */
public class TestListArray {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList();
        LinkedList<Object> linkedList = new LinkedList<Object>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }
}
