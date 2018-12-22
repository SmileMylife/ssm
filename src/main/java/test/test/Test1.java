package test.test;


import com.alibaba.fastjson.JSON;
import com.store.common.OutputObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ZhangPei on 2018/11/1.
 */
public class Test1 {
    public static void main(String[] args) throws ConfigurationException {
        /*String s = null;
        System.out.println(s + "");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s).append("123");
        System.out.println(stringBuilder.toString());


        ArrayList<String> strings = new ArrayList<String>();

        strings.add("12");
        strings.add("123");

        System.out.println(strings.toString());


        System.out.println("\"");

        boolean contains = strings.contains("1");
        System.out.println(contains);

        String[] arr = {"1", "2", "3"};
        List<String> list = Arrays.asList(arr);
        boolean flag = list.contains("1");
        System.out.println(flag);


        PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration("switch.properties");
        String ngwf = propertiesConfiguration.getString("ngwf");
        String[] split = ngwf.split(",");
        List<String> strings1 = Arrays.asList(split);

        System.out.println(ngwf);
        System.out.println(strings1);*/

        /*HashMap<String, Object> map = new HashMap<String, Object>();
        map.putAll(null);*/


        /*ArrayList<String> strings = new ArrayList<String>();
        boolean notEmpty = CollectionUtils.isNotEmpty(strings);
        System.out.println(notEmpty);*/

        String s = "{\n" +
                "    \"object\":null,\n" +
                "    \"rtnCode\":\"0\",\n" +
                "    \"rtnMsg\":\"成功\",\n" +
                "    \"sn\":\"\",\n" +
                "    \"bean\":{\n" +
                "        \"total\":\"5\"\n" +
                "    },\n" +
                "    \"beans\":[\n" +
                "        {\n" +
                "            \"username\":\"zhangpei\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"age\":\"22\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        OutputObject outputObject = JSON.parseObject(s, OutputObject.class);
        System.out.println(outputObject);




        OutputObject output = new OutputObject();
        test1(output);
        System.out.println(output.getBean().toString());

    }

    public static void test1(OutputObject outputObject) {
        test2(outputObject);
    }

    public static void test2(OutputObject outputObject) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("username", "zhangpei");
        OutputObject out = new OutputObject();
        out.setBean(map);
        outputObject = out;
    }
}
