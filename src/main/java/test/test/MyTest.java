package test.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.store.common.InputObject;

import java.util.*;

/**
 * Created by ZhangPei on 2018/8/28.
 */
public class MyTest {
    public static void main(String[] args) {
        ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        map.put("username", "zhangsan");
        map.put("password", 123);

        HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("age", 17);
        map1.put("name", "name");
        map1.put("degree", "xueshi");

        list.add(map1);
        list.add(map);

        ArrayList<Map<String, Object>> beans = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> map3 : list) {
            beans.add(map3);
        }
        System.out.println("beans的内容为：" + beans);
        System.out.println("测试\r\n" + "呵呵");


        /*Map<String, Object> map2 = new HashMap<String, Object>();
        InputObject inputObject = new InputObject();
        map2.put("inputObject", inputObject);
        inputObject.getParams().put("123", "123");
        Object object = map2.get("inputObject");

        System.out.println(object.toString());
        if (object instanceof InputObject) {
            InputObject object1 = (InputObject) object;
            HashMap<String, Object> params = object1.getParams();
            System.out.println(params);
        }

        String[] strings = {"1", "2", "3"};

        JSONObject jsonObject = null;
        String s = jsonObject.toString();

        System.out.println("转JSON结果：" + s);*/
//        testMoreParams(strings);

        int i = "223".compareTo("124");
        System.out.println("比较结果：" + i);

        //测试jsonarray
        ArrayList<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        HashMap<String, Object> map2 = new HashMap<String, Object>();
        map2.put("provCode", "00030015");
        result.add(map2);
        String s = JSON.toJSONString(result);
        JSONArray jsonArray = JSONArray.parseArray(s);

        ArrayList<Map<String, Object>> result1 = new ArrayList<Map<String, Object>>();
        HashMap<String, Object> map3 = new HashMap<String, Object>();
        map3.put("tenantId", "100000");
        result1.add(map3);

        jsonArray.addAll(result1);

        System.out.println(jsonArray);



    }


    public static void testMoreParams(String... str) {
        System.out.println(str[0]);
        System.out.println(str[1]);
        System.out.println(str[10]);

    }
}
