package test.test;

import java.io.*;
import java.util.HashMap;

/**
 * Created by ZhangPei on 2018/9/20.
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {

        /*FileInputStream fileInputStream = new FileInputStream(new File("a.jpg"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("a.jpg"));
        File file = new File("");
        while (true) {
            int read = fileInputStream.read();
            if (read > -1) {
                fileOutputStream.write(read);
                fileOutputStream.flush();
            } else {
                break;
            }
        }
        fileOutputStream.close();*/

        /*int[] ints = new int[12];

        System.out.println(ints[0]);*/

        HashMap<String, Object> map = new HashMap<String, Object>();
        HashMap<String, Object> map1 = new HashMap<String, Object>();

        map1.putAll(map);

    }
}
