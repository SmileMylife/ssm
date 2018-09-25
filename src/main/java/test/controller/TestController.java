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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import test.autosend.AutoSendThread;
import test.autosend.IAutoSendServiceFactory;
import test.common.GeneralException;
import test.dao.IDatasourceInter;
import test.dao.ITestDao;
import test.dbswitch.DbSwitchServiceImpl;
import test.dbswitch.MyClass;
import test.service.ITestService;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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

    @Autowired
    private MyClass myClass;

    @Autowired
    private DbSwitchServiceImpl dbSwitchService;

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
    public OutputObject showUsers(InputObject inputObject, OutputObject outputObject, String dbKey) throws IOException {
        HashMap<String, Object> params = inputObject.getParams();
        params.put("dbKey", dbKey);
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
    public void testTransational(InputObject inputObject, OutputObject outputObject) throws GeneralException {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", "1");
        map.put("username", "zhangsan");
        map.put("password", "12313");
        map.put("user", "user");    //表名
        inputObject.setParams(map);
        iTestService.testTransational(inputObject, outputObject);
    }

    //测试文件上传
    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    @ResponseBody
    public void fileUpload(InputObject inputObject, OutputObject outputObject, HttpServletRequest httpServletRequest, @RequestParam(value = "file")MultipartFile multipartFile, HttpServletResponse httpServletResponse) throws IOException {
        ServletInputStream inputStream = httpServletRequest.getInputStream();


        InputStream fileInputStream = multipartFile.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("a.jpg")));
        int read;
        while (true) {
            read = fileInputStream.read();
            if (read > -1) {
                bufferedOutputStream.write(read);
            } else {
                break;
            }
        }

        httpServletResponse.getWriter().write("1232132131");
        String username = httpServletRequest.getParameter("username");
        System.out.println(username);
    }

    //测试动态切库
    @RequestMapping(value = "switchDatasource", method = RequestMethod.POST)
    @ResponseBody
    public void switchDatasource(InputObject inputObject, OutputObject outputObject, String dbKey) {
        inputObject.getParams().put("dbKey", dbKey);
        inputObject.getParams().put("user", "user");
        iTestService.switchDatasource(inputObject, outputObject);
        List<HashMap<String, Object>> beans = outputObject.getBeans();
        System.out.println(beans.toString());
    }


    //测试批量操作
    @RequestMapping(value = "testBatchOperator", method = RequestMethod.POST)
    @ResponseBody
    public void testBatchOperator() {
        iTestService.testBatchQuery();
    }


    //测试线程池
    @RequestMapping(value = "testThreadPool", method = RequestMethod.POST)
    @ResponseBody
    public void testThreadPool() {
        iTestService.testThreadPool();
    }

    //测试mybatis
    @RequestMapping(value = "testMybatis", method = RequestMethod.POST)
    @ResponseBody
    public void testMybatis() {
        iTestService.testMybatis();
    }

    //测试悲观锁（此处为事务一）
    @RequestMapping(value = "testPessimisticTransaction1", method = RequestMethod.POST)
    @ResponseBody
    public void testPessimisticTransaction1() {
        iTestService.testPessimisticTransaction1();
    }

    //测试悲观锁（此处为事务二）
    @RequestMapping(value = "testPessimisticTransaction2", method = RequestMethod.POST)
    @ResponseBody
    public void testPessimisticTransaction2() {
        iTestService.testPessimisticTransaction2();
    }

    @RequestMapping(value = "testUnionRequest", method = RequestMethod.POST)
    @ResponseBody
    public void testUnionRequest(HttpServletRequest httpServletRequest) {
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        InputObject inputObject = new InputObject();
        HashMap<String, Object> params = inputObject.getParams();
        Set<String> keys = parameterMap.keySet();
        for (String key : keys) {
            String[] values = parameterMap.get(key);
            if (values == null) {
                params.put(key, null);
            } else {
                params.put(key, values.length > 0 ? values[0] : null);
            }
        }
        System.out.println(inputObject);
    }

    @RequestMapping(value = "testParamsFilter", method = RequestMethod.POST)
    @ResponseBody
    public void testParamsFilter(InputObject inputObject, OutputObject outputObject, String provCode, String tenantId) {
        System.out.println(inputObject + provCode + tenantId);
    }
}
