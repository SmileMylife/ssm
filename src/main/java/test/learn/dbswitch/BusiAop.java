package test.learn.dbswitch;

import com.store.common.InputObject;
import org.apache.commons.collections.MapUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by ZhangPei on 2018/8/9.
 */
@Component
@Aspect
@Order(0)
public class BusiAop {

    //定义切点
    @Pointcut("execution(* test.service.impl.ITestServiceImpl.*(..))")
    public void aspect() {
        System.out.println("切点");
    }

    @Before(value = "aspect()")
    public void getDbKey(JoinPoint joinPoint) {
        //在进入service方法之前拿到参数列表
        Object[] args = joinPoint.getArgs();
        //假设此处入参统一为inputobject,outputobject
        InputObject inputObject = (InputObject) args[0];
        HashMap<String, Object> params = inputObject.getParams();
        System.out.println("执行前置通知" + MapUtils.getString(params, "dbKey"));
        //将参数放入threadLocal
        DataSourceHandle.setDbKey(MapUtils.getString(params, "dbKey"));
    }
}
