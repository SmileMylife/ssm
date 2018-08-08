package test.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.store.common.InputObject;
import com.store.common.OutputObject;
import com.store.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import test.autosend.AutoSendServiceFactory;
import test.autosend.AutoSendThread;
import test.autosend.IAutoSendServiceFactory;
import test.service.ITestService;

import java.io.IOException;
import java.util.*;

/**
 * Created by ZhangPei on 2018/7/23.
 */
@Controller
public class TestController {

    @Autowired
    private IAutoSendServiceFactory autoSendServiceFactory;

    @Autowired
    private ITestService iTestService;

    @RequestMapping(value = "/parseJson", method = RequestMethod.POST)
    @ResponseBody
    public void parseJson(String jsonString) {
        if (StringUtils.isBlank(jsonString)) {
            return;
        }
        List<Map<String, Object>> parse = (List<Map<String, Object>>) JSONObject.parse(jsonString);
        for (int i = 0; i < parse.size(); i++) {
            System.out.println(parse.get(i));
        }
    }

    //测试json
    @RequestMapping(value = "/testJson", method = RequestMethod.POST)
    @ResponseBody
    public User jsonParse(String jsonParams) {
        JSONArray objects = JSONObject.parseArray(jsonParams);
        ListIterator<Object> objectListIterator = objects.listIterator();
        while (objectListIterator.hasNext()) {
            Object next = objectListIterator.next();
            System.out.println(next);
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("username", "zhangpei");
        map.put("password", "123");
        String s = JSONObject.toJSONString(map);

        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        list.add(map);

        OutputObject outputObject = new OutputObject();
        outputObject.setBean(map);
        outputObject.setBeans(list);

        User user = new User();
        user.setUsername("zhnagsan");
        user.setPassword("123");

        return user;
    }

    //测试显示用户列表
    @RequestMapping(value = "/showUsers", method = RequestMethod.POST)
    @ResponseBody
    public OutputObject showUsers(InputObject inputObject, OutputObject outputObject) throws IOException {
        iTestService.showUsers(inputObject, outputObject);
        return outputObject;
    }

    //测试自动派单
    @RequestMapping(value = "/testAutoSend", method = RequestMethod.POST)
    @ResponseBody
    public void testAtuoSend(String rltSysCode) {
        AutoSendThread autoSendThread = new AutoSendThread(autoSendServiceFactory, rltSysCode);
        autoSendThread.run();
    }

    @RequestMapping(value = "testTransational", method = RequestMethod.POST)
    @ResponseBody
    //测试事务管理
    public void testTransational(InputObject inputObject, OutputObject outputObject) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", "1");
        map.put("username", "ZHAIY");
        map.put("password", "12313");
        map.put("user", "user");    //表名
        inputObject.setParams(map);
        iTestService.testTransational(inputObject, outputObject);
    }
}
