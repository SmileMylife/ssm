package test.test;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ZhangPei on 2018/10/17.
 */
public class TestSort {
    public static void main(String[] args) {
        String code1 = "1810171524330146003";
        String code2 = "1810171524330146001";
        String code3 = "1810171524330146002";
        String code4 = "1810171524330146100";

        String[] arr = {"1810171524330146001", "1810171524330146002", "1810171524330146003", "1810171524330146100"};
        List<String> strings = Arrays.asList(arr);

        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(strings);


    }
}
