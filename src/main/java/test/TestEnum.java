package test;

import com.store.common.ResponseCode;
import com.store.utils.MD5Util;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZhangPei on 2018/4/7.
 */
public class TestEnum {
    public static void main(String[] args) {
        int code = ResponseCode.SUCCESS.getCode();
        String desc = ResponseCode.SUCCESS.getDesc();
        System.err.println(code + "\t" + desc);
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$");
        Matcher matcher = pattern.matcher("843833414@qq.com");
        boolean matches = matcher.matches();
        if (matches) {
            System.err.println("校验通过");
        }else {
            System.err.println("校验不通过");
        }


        //测试isblank和isempty
        boolean blank = StringUtils.isBlank(null);
        System.err.print(blank + "\t");
        boolean empty = StringUtils.isEmpty(null);
        System.err.print(empty + "\t");
        boolean blank1 = StringUtils.isBlank("");
        System.err.print(blank1 + "\t");
        boolean empty2 = StringUtils.isEmpty("");
        System.err.print(empty2 + "\t");
        boolean notBlank = StringUtils.isBlank("  ");
        System.err.print(notBlank + "\t");
        boolean notEmpty = StringUtils.isEmpty("  ");
        System.err.print(notEmpty + "\t");
        boolean notEmpty2 = StringUtils.isEmpty("   zhangsan");
        System.err.print(notEmpty2 + "\t");
        boolean notBlank2 = StringUtils.isBlank("   zhangsan");
        System.err.print(notBlank2 + "\t");

        //测试isnotblank和isnotempty
        boolean blank5 = StringUtils.isNotBlank(null);
        System.err.print(blank5 + "\t");
        boolean empty5 = StringUtils.isNotEmpty(null);
        System.err.print(empty5 + "\t");
        boolean blank6 = StringUtils.isNotBlank("");
        System.err.print(blank6 + "\t");
        boolean empty6 = StringUtils.isNotEmpty("");
        System.err.print(empty6 + "\t");
        boolean notEmpty1 = StringUtils.isNotEmpty("   ");
        System.err.print(notEmpty1 + "\t");
        boolean notBlank1 = StringUtils.isNotBlank("   ");
        System.err.print(notBlank1 + "\t");
        boolean notEmpty3 = StringUtils.isNotEmpty("   zhangsan");
        System.err.print(notEmpty3 + "\t");
        boolean notBlank3 = StringUtils.isNotBlank("   zhangsan");
        System.err.print(notBlank3 + "\t");

        String s = MD5Util.MD5EncodeUtf8("123");
        System.err.println(s);

    }
}
