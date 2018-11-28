package test.project.autosend;

import com.store.common.InputObject;
import com.store.common.OutputObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.project.autosend.outter.INewSysToOldSysCommonService;
import test.project.autosend.outter.IProvToMidsCommonService;

/**
 * Created by ZhangPei on 2018/7/31.
 */
@Service
public class AutoSendServiceFactory implements IAutoSendServiceFactory {
    @Autowired
    private INewSysToOldSysCommonService iNewSysToOldSysCommonService;
    @Autowired
    private IProvToMidsCommonService iProvToMidsCommonService;

    public ICommonAutoSend createService(String rltSysCode) {
        //可改造为配置文件形式

        if ("NSOS".equals(rltSysCode)) {
            //创建新老系统service
            return iNewSysToOldSysCommonService;
        } else if ("PDLC".equals("PDLC")) {
            return iProvToMidsCommonService;
        }
        return null;
    }

    //执行相应方法
    public void invokeMethod(String rltSysCode, InputObject inputObject, OutputObject outputObject) {
        if ("NSOS".equals(rltSysCode)) {
            //创建新老系统service
            iNewSysToOldSysCommonService.sendToNsos(inputObject, outputObject);
        } else if ("PDLC".equals(rltSysCode)) {
            iProvToMidsCommonService.sendToMids(inputObject, outputObject);
        }
    }
}
