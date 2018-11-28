package test.project.autosend;

import com.store.common.InputObject;
import com.store.common.OutputObject;
import test.project.autosend.outter.INewSysToOldSysCommonService;

/**
 * Created by ZhangPei on 2018/7/31.
 */
public class AutoSendThread implements Runnable {
    private ICommonAutoSend iCommonAutoSend;
    private IAutoSendServiceFactory iAutoSendServiceFactory;
    private String rltSysCode;

    public AutoSendThread(ICommonAutoSend iCommonAutoSend, String rltSysCode) {
        this.iCommonAutoSend = iCommonAutoSend;
        this.rltSysCode = rltSysCode;
    }

    public AutoSendThread(IAutoSendServiceFactory iAutoSendServiceFactory, String rltSysCode) {
        this.iAutoSendServiceFactory = iAutoSendServiceFactory;
        this.rltSysCode = rltSysCode;
    }

    @Override
    public void run() {
        if (iCommonAutoSend instanceof INewSysToOldSysCommonService) {
            System.out.println("是新老系统的实例");
        }
        InputObject inputObject = new InputObject();
        OutputObject outputObject = new OutputObject();
        iAutoSendServiceFactory.invokeMethod(rltSysCode, inputObject, outputObject);
    }
}
