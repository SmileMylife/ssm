package test.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.project.inter.IOutSysServiceRequestAccept;

/**
 * Created by ZhangPei on 2018/5/12.
 */
public class TestSwitch {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IOutSysServiceRequestAccept outSysServiceRequestAccept = (IOutSysServiceRequestAccept) applicationContext.getBean("outSysServiceRequestAccept");
        Object str = outSysServiceRequestAccept.testRest("1", "2");

        System.out.println(str);
    }
}
