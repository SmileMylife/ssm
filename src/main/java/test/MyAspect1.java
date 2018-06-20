package test;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangPei on 2018/5/10.
 */
@Component
@Aspect
public class MyAspect1 {
    @Pointcut("execution(* test.ProductServiceImpl.haha(..))")
    public void transactionPointCut() {

    }

    @Before("transactionPointCut()")
    public Object before(JoinPoint joinPoint) throws Throwable {
        System.out.println("前置通知已执行");
        Object[] args = joinPoint.getArgs();
        for (Object o :
                args) {
            System.out.println("传入参数为" + o);
        }
        PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration("switch.properties");
        boolean aSwitch = propertiesConfiguration.getBoolean("switch");
        return "返回字符串";
    }
}
