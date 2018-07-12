package test.jdkproxy.scene1.impl;

import org.springframework.stereotype.Service;
import test.jdkproxy.scene1.IOutSysDeal;

/**
 * Created by ZhangPei on 2018/6/28.
 */
@Service
public class OutSysDealImpl implements IOutSysDeal {
    /**
     * 此处为原始需求，如果需要添加确认受理则需在原始逻辑中进行添加，假设在此处
     * 添加后，后边又不要确认受理，那么改动会很麻烦
     */
    @Override
    public void urgeOutSys() {
        System.out.println("催单外系统");
    }
}
