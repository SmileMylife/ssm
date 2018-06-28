package test.jdkproxy.scene1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 原始需求为催单前不需要任何校验，现要求催单前要进行确认是否确认受理
 * Created by ZhangPei on 2018/6/28.
 */
@Controller
public class AcceptService {
    @Autowired
    @Qualifier("outSysDealImpl")
    private IOutSysDeal iOutSysDeal;

    @RequestMapping("/urgeOutSys")
    public void urgeOutSys(String input, String output) {
        iOutSysDeal.urgeOutSys();
    }
}
