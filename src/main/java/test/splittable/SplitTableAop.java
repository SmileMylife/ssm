package test.splittable;

import com.store.common.InputObject;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import test.utils.PropertiesUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by ZhangPei on 2018/9/12.
 */
@Component
@Aspect
@Order(1)
public class SplitTableAop {
    @Pointcut(value = "execution(* test.service.impl.*.*(..))")
    public void pointCut() {
        System.out.println("切点表达式");
    }

    //对方法执行环绕通知，获取参数中的CRT_TIME
    @Before("pointCut()")
    public void splitTable(JoinPoint joinPoint) throws ConfigurationException, ParseException {
        Object[] args = joinPoint.getArgs();
        if (args != null && args[0] instanceof InputObject) {
            InputObject inputObject = (InputObject) args[0];
            HashMap<String, Object> params = inputObject.getParams();
            String crt_time = MapUtils.getString(params, "CRT_TIME");
            if (StringUtils.isNotBlank(crt_time)) {
                String tableName = MapUtils.getString(params, "table_name");
                String splitRule = PropertiesUtil.getString("splitTable.properties", tableName);
                if (StringUtils.isNotBlank(splitRule)) {
                    //处理分表逻辑
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(splitRule);
                    String extTableName = simpleDateFormat.format(DateUtils.parseDate(crt_time, "yyyy:MM:dd HH:mm:ss"));
                    //拼接表名
                    tableName += "_" + extTableName;
                    params.put("table_name", tableName);
                }
            }
        }
    }
}
