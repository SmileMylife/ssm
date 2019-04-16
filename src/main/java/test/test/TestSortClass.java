package test.test;

import java.util.Arrays;

/**
 * Created by ZhangPei on 2019/2/21.
 */
public class TestSortClass {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 0};
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
