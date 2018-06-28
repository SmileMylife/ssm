package test.project.impl;

import com.store.common.InputObject;
import com.store.common.OutputObject;

/**
 * Created by ZhangPei on 2018/6/22.
 */
public class HuBeiEcssSys extends OutSysOperateServiceImpl {
    @Override
    public void reSendToOutSys(InputObject inputObject, OutputObject outputObject) throws Exception {
        System.out.println("湖北ECSS平台重派单");
    }
}
