package test.test;

import com.store.pojo.User;

import java.util.*;

/**
 * Created by ZhangPei on 2019/2/16.
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();

        ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("username", "zhangpei");
        map1.put("password", "123");
        list.add(map1);

        map = list.get(0);


        HashMap<String, Object> map2 = new HashMap<String, Object>();
        map2.put("username", "zhangxu");
        map2.put("password", "456");
        list.set(0, map2);

        System.out.println(map);

        User user = new User();
        user.setUsername("zhangpei");
        user.setPassword("123");

        User user1;
        user1 = user;

        user.setPassword("456");
        System.out.println(user1.getPassword());

        String s = "haha|niqusi";
        String[] split = s.split("\\|");
        System.out.println(Arrays.toString(split));

        HashSet<Map<String, Object>> maps = new HashSet<Map<String, Object>>();
        HashMap<String, Object> map3 = new HashMap<String, Object>();
        map3.put("provCode", "00030016");
        maps.add(map3);

        HashMap<String, Object> map4 = new HashMap<String, Object>();
        map4.put("provCode", "00030015");
        maps.add(map4);


        HashMap<String, Object> map5 = new HashMap<String, Object>();
        map5.put("provCode", "00030017");
        ArrayList<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
        list1.add(map5);

        maps.addAll(list1);


        System.out.println(maps);

    }
}
