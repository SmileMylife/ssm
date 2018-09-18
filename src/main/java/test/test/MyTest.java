package test.test;

import com.store.common.InputObject;
import org.apache.ibatis.session.SqlSession;

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


        Map<String, Object> map2 = new HashMap<String, Object>();
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
    }
}
