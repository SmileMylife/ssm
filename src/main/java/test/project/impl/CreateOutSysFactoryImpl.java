package test.project.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import com.project.utils.PropertiesUtil;
import test.project.inter.CreateOutSysFactory;
import test.project.inter.OutSysOperateService;

/**
 * Created by ZhangPei on 2018/6/22.
 */
@Component
public class CreateOutSysFactoryImpl implements CreateOutSysFactory {

    /**
     * 根据系统编码创建相应的系统实现类
     * @param sysCode
     * @throws Exception
     */
    @Override
    public OutSysOperateService createOutSys(String sysCode) throws Exception {
        String outSysClassConfig = PropertiesUtil.getValueByFile("outSysClassConfig.properties", sysCode);
        if (StringUtils.isBlank(outSysClassConfig)) {
            throw new Exception("未配置外系统编码对应的类");
        }
        //利用相应的类名创建对应的对象
        Class<?> aClass = Class.forName(outSysClassConfig);
        OutSysOperateService outSysOperateService = (OutSysOperateService) aClass.newInstance();
        if (outSysOperateService == null) {
            throw new Exception("根据类名获取的对象为空");
        }
        return outSysOperateService;
    }
}
