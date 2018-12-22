package test.test;

/**
 * Created by ZhangPei on 2018/12/10.
 */
public class ReplaceXMLSpace {
    public static void main(String[] args) {
        String s = "";  //xml报文模板
        System.out.println(s.replace("\r\n", "").replace("  ", ""));
    }
}
