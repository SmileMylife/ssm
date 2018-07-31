package test.autosend.outter.impl;

import com.store.common.InputObject;
import com.store.common.OutputObject;
import org.springframework.stereotype.Service;
import test.autosend.outter.INewSysToOldSysCommonService;

/**
 * Created by ZhangPei on 2018/7/31.
 */
@Service
public class NewSysToOldSysCommonServiceImpl implements INewSysToOldSysCommonService {
    public void sendToNsos(InputObject inputObject, OutputObject outputObject) {
        System.out.println("派单新老系统");
    }
}
