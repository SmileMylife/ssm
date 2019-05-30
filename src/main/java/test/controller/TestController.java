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
import test.project.autosend.AutoSendThread;
import test.project.autosend.IAutoSendServiceFactory;
import test.common.GeneralException;
import test.learn.dbswitch.DbSwitchServiceImpl;
import test.learn.dbswitch.MyClass;
import test.learn.paramresolver.InputObjectAnnotation;
import test.service.ITestService;

import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ZhangPei on 2018/7/23.
 */
@Controller
public class TestController {
    private int num = 0;

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
    public OutputObject showUsers(@InputObjectAnnotation InputObject inputObject, OutputObject outputObject) throws IOException {
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
        iTestService.testTransational(inputObject, outputObject);
    }

    //测试文件上传
    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    @ResponseBody
    public void fileUpload(InputObject inputObject, OutputObject outputObject, HttpServletRequest httpServletRequest, @RequestParam(value = "file") MultipartFile multipartFile, HttpServletResponse httpServletResponse) throws IOException {
        ServletInputStream inputStream = httpServletRequest.getInputStream();
        String servletPath = httpServletRequest.getServletPath();               //结果：/fileUpload
        ServletContext servletContext = httpServletRequest.getServletContext();
        String realPath = servletContext.getRealPath("/");            //结果：/Users/smile_mylife/....绝对路径
        String contextPath = httpServletRequest.getContextPath();       //结果：/ssm

        String name = multipartFile.getOriginalFilename();
        int index = name.lastIndexOf(".");
        String extandType = name.substring(index + 1, name.length());
        UUID uuid = UUID.randomUUID();
        String fileName = uuid.toString();

        InputStream fileInputStream = multipartFile.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        String path = "uploads/";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(path + fileName + "." + extandType)));
        int read;
        while (true) {
            read = fileInputStream.read();
            if (read > -1) {
                bufferedOutputStream.write(read);
            } else {
                break;
            }
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();

        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.getWriter().write(new String("向页面返回文字内容".getBytes("UTF-8"), "utf-8"));
        String username = httpServletRequest.getParameter("username");
        System.out.println(username);
    }

    @RequestMapping(value = "fileDownload", method = RequestMethod.GET)
    public void fileDownload(HttpServletResponse response, String fileName) throws Exception {
        //方法一
        if (StringUtils.isBlank(fileName)) {
            throw new Exception("文件下载失败，文件名为空");
        }
        FileInputStream fileInputStream = new FileInputStream(new File(fileName));
        ServletOutputStream outputStream = response.getOutputStream();
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", "attachment; filename=" + "testfilename");

        int lenth;
        while ((lenth = fileInputStream.read()) > -1) {
            outputStream.write(lenth);
            outputStream.flush();
        }
        outputStream.close();

        /*//方法二
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentDispositionFormData("attachment", "filename.jpg");
        byte[] bytes = FileUtils.readFileToByteArray(new File("a.jpg"));
        return new ResponseEntity<byte[]>(bytes, httpHeaders, HttpStatus.OK);*/
    }

    //测试动态切库
    @RequestMapping(value = "switchDatasource", method = RequestMethod.POST)
    @ResponseBody
    public void switchDatasource(InputObject inputObject, OutputObject outputObject) {
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

    //测试参数过滤器
    @RequestMapping(value = "testParamsFilter", method = RequestMethod.POST)
    @ResponseBody
    public void testParamsFilter(@InputObjectAnnotation InputObject inputObject, OutputObject outputObject, String provCode, String tenantId) {
        System.out.println(inputObject + provCode + tenantId);
    }

    //测试参数封装
    @RequestMapping(value = "/testParamPackage", method = RequestMethod.POST)
    @ResponseBody
    public void testParamPackage(@RequestParam Map<String, Object> param, HttpServletRequest httpServletRequest, @InputObjectAnnotation InputObject inputObject) {
        HashMap<String, Object> params = inputObject.getParams();
        System.out.println("入参params的值为：" + params);
    }

    //测试页面跳转
    @RequestMapping(value = "/breakToProducts", method = RequestMethod.GET)
    public String breakToProducts(@InputObjectAnnotation InputObject inputObject, OutputObject outputObject) {
        return "products";
    }

    //测试分表，经测试AOP中对参数进行更改时，操作的就是执行该方法时的入参，可以在dubug模式下进行查看变量地址，发现在aop中该变量所指向的地址相同。
    @RequestMapping(value = "/testSplitTable", method = RequestMethod.POST)
    @ResponseBody
    public String testSplitTable(@InputObjectAnnotation InputObject inputObject, OutputObject outputObject) {
        //前台传入一个wrkfmId和dbKey进来，后台传入一个日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:dd");
        String format = simpleDateFormat.format(new Date());
        HashMap<String, Object> params = inputObject.getParams();
        params.put("CRT_TIME", format);
        iTestService.testSplitTable(inputObject, outputObject);
        return "";
    }

    //测试两个请求同时发出，后台代码在进行处理的时候是否会阻塞，测试结果显示并不会阻塞。
    @RequestMapping(value = "/testRequestPrevent", method = RequestMethod.GET)
    @ResponseBody
    public void testRequestPrevent(String name) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.println(name + num++);
            }
        }
    }

    //测试日志打印
    @RequestMapping(value = "/testPrintLog", method = RequestMethod.GET)
    @ResponseBody
    public void testPrintLog(@InputObjectAnnotation InputObject inputObject, OutputObject outputObject) {
        iTestService.testPrintLog(inputObject, outputObject);
    }

    @RequestMapping(value = "/testXss", method = RequestMethod.POST)
    @ResponseBody
    public String testXss(String xssCode) {
        return xssCode;
    }

    @RequestMapping(value = "/testInsert", method = RequestMethod.POST)
    @ResponseBody
    public void testInsert() {
        iTestService.testInsert();
    }
}
