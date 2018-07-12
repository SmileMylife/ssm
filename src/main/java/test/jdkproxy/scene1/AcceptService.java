package test.jdkproxy.scene1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 原始需求为催单前不需要任何校验，现要求催单前要进行确认是否确认受理
 * Created by ZhangPei on 2018/6/28.
 */
@Controller
public class AcceptService {
    @Autowired
//    @Qualifier("outSysDealImpl")    //原始需求
    @Qualifier("outSysDealProxyImpl")   //更改后的需求
    private IOutSysDeal iOutSysDeal;

    @RequestMapping(value = "/urgeOutSys", method = RequestMethod.POST)
    @ResponseBody
    public void urgeOutSys(String input, String output) {
        iOutSysDeal.urgeOutSys();
    }
}
