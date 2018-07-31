package test.project;

import com.store.common.InputObject;
import com.store.common.OutputObject;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import test.project.inter.CreateOutSysFactory;
import test.project.inter.IOutSysServiceRequestAccept;

import java.util.HashMap;

/**
 * Created by ZhangPei on 2018/6/22.
 */
@Controller
@RequestMapping("/outSys")
public class OutSysServiceRequestAccept implements IOutSysServiceRequestAccept {
    @Autowired
    private CreateOutSysFactory createOutSysFactory;

    /**
     * 派转外系统
     *
     * @param inputObject
     * @param outputObject
     * @throws Exception
     */
    @RequestMapping(value = "/sendToOutSys", method = RequestMethod.POST)
    public String sendToOutSys(InputObject inputObject, OutputObject outputObject) throws Exception {
        HashMap<String, Object> params = inputObject.getParams();
        String sysCode = MapUtils.getString(params, "sysCode");
        sysCode = "CSVC";
        if (StringUtils.isBlank(sysCode)) {
            throw new Exception("系统编码为空");
        }
        createOutSysFactory.createOutSys(sysCode).sendToOutSys(inputObject, outputObject);
        return "index";
    }

    /**
     * 重派外系统
     *
     * @param inputObject
     * @param outputObject
     * @throws Exception
     */
    @RequestMapping(value = "/reSendToOutSys", method = RequestMethod.POST)
    public void ReSendToOutSys(InputObject inputObject, OutputObject outputObject) throws Exception {
        HashMap<String, Object> params = inputObject.getParams();
        String sysCode = MapUtils.getString(params, "sysCode");
        if (StringUtils.isBlank(sysCode)) {
            throw new Exception("系统编码为空");
        }
        createOutSysFactory.createOutSys(sysCode).reSendToOutSys(inputObject, outputObject);
    }


    /**
     * 中途意见外系统
     *
     * @param inputObject
     * @param outputObject
     * @throws Exception
     */
    @RequestMapping(value = "/midAdviceOutSys", method = RequestMethod.POST)
    public void midAdviceOutSys(InputObject inputObject, OutputObject outputObject) throws Exception {
        HashMap<String, Object> params = inputObject.getParams();
        String sysCode = MapUtils.getString(params, "sysCode");
        if (StringUtils.isBlank(sysCode)) {
            throw new Exception("系统编码为空");
        }
        createOutSysFactory.createOutSys(sysCode).midAdviceOutSys(inputObject, outputObject);
    }

    /**
     * 测试rest请求
     * @param inputObject
     * @param outputObject
     */
    @RequestMapping(value = "/testRest", method = RequestMethod.POST)
    @ResponseBody
    public Object testRest(String inputObject, String outputObject) {
        System.out.println("测试开始");
        return null;
    }

}
