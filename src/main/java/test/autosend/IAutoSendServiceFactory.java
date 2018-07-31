package test.autosend;

import com.store.common.InputObject;
import com.store.common.OutputObject;

/**
 * Created by ZhangPei on 2018/7/31.
 */
public interface IAutoSendServiceFactory {
    public void invokeMethod(String rltSysCode, InputObject inputObject, OutputObject outputObject);
}
