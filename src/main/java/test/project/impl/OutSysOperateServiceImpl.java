package test.project.impl;

import com.store.common.InputObject;
import com.store.common.OutputObject;
import test.project.inter.OutSysOperateService;

/**
 * Created by ZhangPei on 2018/6/22.
 */
public class OutSysOperateServiceImpl implements OutSysOperateService {


    @Override
    public void sendToOutSys(InputObject inputObject, OutputObject outputObject) throws Exception {
        System.out.println("通用派单相关逻辑");
    }

    @Override
    public void reSendToOutSys(InputObject inputObject, OutputObject outputObject) throws Exception {
        System.out.println("通用重派相关逻辑");
    }

    @Override
    public void midAdviceOutSys(InputObject inputObject, OutputObject outputObject) throws Exception {
        System.out.println("通用中途意见相关逻辑");
    }
}
