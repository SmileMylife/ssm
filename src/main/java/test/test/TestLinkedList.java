package test.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ZhangPei on 2018/8/3.
 */
public class TestLinkedList {
    public static void main(String[] args) {
        /*long start = System.currentTimeMillis();
        LinkedList<Object> linkedList = new LinkedList<Object>();
        for (int i = 0; i < 100; i++) {
            linkedList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);


        long start1 = System.currentTimeMillis();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);*/
        long start = System.currentTimeMillis();
        Set<Object> set = new HashSet<Object>();
        for (int i = 0; i < 10000; i++) {
            set.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        long start1 = System.currentTimeMillis();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

        String s = "zhangsan";
        String[] split = s.split(",");
        String s1 = Arrays.toString(split);
        System.out.println(s1);


        String s2 = JSONObject.toJSONString(new Integer(1));
        System.out.println(s2);

    }
}
