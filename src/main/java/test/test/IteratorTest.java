package test.test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ZhangPei on 2018/8/30.
 */
public class IteratorTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        for (Object i : arrayList) {
            if (Integer.parseInt(i.toString()) == 2) {
                arrayList.remove(i);
            }
        }
    }
}
