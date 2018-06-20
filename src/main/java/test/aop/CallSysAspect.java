package test.aop;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangPei on 2018/5/12.
 */
@Component
@Aspect
public class CallSysAspect {
    @Pointcut("execution(* test.aop.IcallOutSysServiceImpl.callSys(..))")
    public void aspect() {

    }
    @Around("aspect()")
    public Object switchProperties(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("执行派转外系统前");
        PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration("switch.properties");
        boolean aSwitch = propertiesConfiguration.getBoolean("switch");
        Object proceed = proceedingJoinPoint.proceed();
        if (aSwitch) {
            System.out.println("执行带有CSF编码的派转");
            proceed = "执行失败，请配置编码";
        }else {
            proceed = "执行本地配置，直接返回数据";
        }
        return proceed;
    }
    @Around("aspect2()")
    public Object switchConfig(ProceedingJoinPoint proceedingJoinPoint) throws ConfigurationException {
        //判断开关是否打开
        PropertiesConfiguration pro = new PropertiesConfiguration("switch.properties");
        boolean aSwitch = pro.getBoolean("switch");
        if (aSwitch) {
            System.out.println("执行远程操作");
            return "远程操作结果2";
        }else {
            return "本地测试数据2";
        }
    }
    @Pointcut("execution(* test.aop.IcallOutSysServiceImpl.callOutSys(..))")
    public void aspect2() {

    }
}
