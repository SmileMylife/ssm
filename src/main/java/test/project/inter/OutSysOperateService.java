package test.project.inter;

import com.store.common.InputObject;
import com.store.common.OutputObject;

/**
 * Created by ZhangPei on 2018/6/22.
 */
public interface OutSysOperateService {
    //派单
    public void sendToOutSys(InputObject inputObject, OutputObject outputObject) throws Exception;

    //重派
    public void reSendToOutSys(InputObject inputObject, OutputObject outputObject) throws Exception;

    //中途意见
    public void midAdviceOutSys(InputObject inputObject, OutputObject outputObject) throws Exception;

}
