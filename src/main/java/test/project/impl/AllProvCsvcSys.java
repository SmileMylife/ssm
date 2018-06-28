package test.project.impl;

import com.store.common.InputObject;
import com.store.common.OutputObject;
import test.project.impl.OutSysOperateServiceImpl;

/**
 * Created by ZhangPei on 2018/6/22.
 */
public class AllProvCsvcSys extends OutSysOperateServiceImpl {
    @Override
    public void sendToOutSys(InputObject inputObject, OutputObject outputObject) throws Exception {
        System.out.println("一级客服派单外系统");
    }
}
