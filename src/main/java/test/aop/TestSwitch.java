package test.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ZhangPei on 2018/5/12.
 */
public class TestSwitch {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IcallOutSysService icallOutSysServiceImpl = (IcallOutSysService) applicationContext.getBean("icallOutSysServiceImpl");
        Object str = icallOutSysServiceImpl.callOutSys("入参string");
        System.out.println(str);
    }
}
