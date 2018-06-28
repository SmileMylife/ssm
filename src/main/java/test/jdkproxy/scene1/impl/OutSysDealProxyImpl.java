package test.jdkproxy.scene1.impl;

import org.springframework.stereotype.Service;
import test.jdkproxy.scene1.*;

/**
 * Created by ZhangPei on 2018/6/28.
 */
@Service
public class OutSysDealProxyImpl implements IOutSysDeal {
    private OutSysDealImpl outSysDeal;

    @Override
    public void urgeOutSys() {
        System.out.println("是否确认受理");
        outSysDeal.urgeOutSys();        //原始外系统催单
    }
}
