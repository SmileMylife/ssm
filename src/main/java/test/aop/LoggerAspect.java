package test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangPei on 2018/7/12.
 * 执行业务代码时，自动打印入参及出参日志
 */
@Component
@Aspect
@Order(2)
public class LoggerAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(void test.service.ITestService.testPrintLog(..))")
    public void aspect() {

    }


    /**
     * 在业务方法执行前后打印入参和出参
     * @param proceedingJoinPoint
     */
    @Around("aspect()")
    public void printLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        Object target = proceedingJoinPoint.getTarget();

        target.getClass().getMethods();

        logger.error("执行业务方法入参为：" + args[0]);

        logger.error("目标类为：" + target);

        Object proceed = proceedingJoinPoint.proceed();

        System.out.println("打印执行记录");

        logger.error("执行业务方法之后方法返回值：" + proceed);

        logger.error("执行业务方法之后出参为：" + args[1]);

    }
}
