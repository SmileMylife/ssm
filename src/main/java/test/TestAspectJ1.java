package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ZhangPei on 2018/5/11.
 */
public class TestAspectJ1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService userServiceImpl = (ProductService) context.getBean("productServiceImpl");
        String haha = userServiceImpl.haha("张佩");
        System.out.println("finalResult" + haha);
    }
}
