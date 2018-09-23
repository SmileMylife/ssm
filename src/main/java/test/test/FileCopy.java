package test.test;

import java.io.*;

/**
 * Created by ZhangPei on 2018/9/20.
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("1537435143384.jpg"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("a.jpg"));

        while (true) {
            int read = fileInputStream.read();
            if (read > -1) {
                fileOutputStream.write(read);
                fileOutputStream.flush();
            } else {
                break;
            }
        }
        fileOutputStream.close();
    }
}
