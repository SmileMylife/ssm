package test.webservice;

/**
 * Created by ZhangPei on 2018/12/18.
 */
public class ITestWebServiceImpl implements ITestWebService {
    /**
     * IDEA可自动生成webservice客户端和服务端，注意生成web.xml
     * @param s
     */
    public void test(String s) {
        System.out.println(s);
    }
}
