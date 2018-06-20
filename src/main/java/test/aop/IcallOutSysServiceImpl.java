package test.aop;

import org.springframework.stereotype.Component;

/**
 * Created by ZhangPei on 2018/5/12.
 */
@Component
public class IcallOutSysServiceImpl implements IcallOutSysService {
    @Override
    public Object callSys(String string) {
        System.out.println("执行调用外系统");
        return string;
    }

    @Override
    public Object callOutSys(String string) {
        System.out.println("执行调用外系统操作2");
        return string;
    }
}
