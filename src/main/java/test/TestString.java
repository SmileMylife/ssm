package test;

import org.apache.commons.lang.StringUtils;

/**
 * Created by ZhangPei on 2018/5/8.
 */
public class TestString {
    public static void main(String[] args) {
        boolean notEmpty = StringUtils.isNotEmpty(" ");
        System.err.println(notEmpty);
    }
}
