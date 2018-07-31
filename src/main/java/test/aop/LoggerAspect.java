package test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangPei on 2018/7/12.
 */
@Component
@Aspect
public class LoggerAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Pointcut("execution(void test.project.OutSysServiceRequestAccept.testRest(..))")
    public void aspect() {

    }

    /*@Around("aspect()")
    public void printLog(ProceedingJoinPoint proceedingJoinPoint) {

    }*/

    @Before("aspect()")
    public void printLog(JoinPoint joinPoint) {
        System.out.println("前置通知执行");
        logger.error(String.valueOf(joinPoint.getArgs()[0]));
    }

}
