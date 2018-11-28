package test.project.autosend.outter.impl;

import com.store.common.InputObject;
import com.store.common.OutputObject;
import org.springframework.stereotype.Service;
import test.project.autosend.outter.IProvToMidsCommonService;

/**
 * Created by ZhangPei on 2018/7/31.
 */
@Service
public class ProvToMidsCommonServiceImpl implements IProvToMidsCommonService {
    public void sendToMids(InputObject inputObject, OutputObject outputObject) {
        System.out.println("派单综调");
    }
}
