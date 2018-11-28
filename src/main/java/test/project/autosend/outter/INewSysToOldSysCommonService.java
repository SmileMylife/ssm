package test.project.autosend.outter;

import com.store.common.InputObject;
import com.store.common.OutputObject;
import test.project.autosend.ICommonAutoSend;

/**
 * Created by ZhangPei on 2018/7/31.
 */
public interface INewSysToOldSysCommonService extends ICommonAutoSend {
    public void sendToNsos(InputObject inputObject, OutputObject outputObject);
}
