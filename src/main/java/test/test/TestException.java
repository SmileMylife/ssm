package test.test;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by ZhangPei on 2018/8/30.
 */
public class TestException {
    public static void main(String[] args) {
        try {
            String utf8 = URLEncoder.encode("%12%3", "utf8");
            URLDecoder.decode(utf8, "utf8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("出错");
            e.printStackTrace();
        }
    }
}
