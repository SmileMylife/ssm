package test.test;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ZhangPei on 2018/8/14.
 */
public class TestEnum {
    public static void main(String[] args) {
        /*Sexy man = Sexy.MAN;
        String[] arr = {"1", "2", "3"};
        System.out.println(arr[0]);
        String s = "";
        s.length();*/

        /*HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("username", "123");


        HashMap<String, Object> map1;

        map1 = map;

        map1.put("password", "123");

        System.out.println(map);

        String s = "{'params': {'username':'zhangsan', 'password':'lisi'}}";

        JSONObject jsonObject = JSON.parseObject(s);
        Object params = jsonObject.get("params");


        System.out.println(params instanceof JSONObject);*/

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("username", "zhangpei");
        map.put("password", "123");

        Set<String> strings = map.keySet();
        /*Iterator<String> iterator = strings.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }*/

        for (String s: strings) {
            System.out.println(s);
        }
    }
}
