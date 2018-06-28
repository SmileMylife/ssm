package test.jdkproxy.scene1.impl;

import org.springframework.stereotype.Service;
import test.jdkproxy.scene1.IOutSysDeal;

/**
 * Created by ZhangPei on 2018/6/28.
 */
@Service
public class OutSysDealImpl implements IOutSysDeal {
    @Override
    public void urgeOutSys() {
        System.out.println("催单外系统");
    }
}
