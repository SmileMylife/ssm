package com.store.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangPei on 2018/4/27.
 */
public class TestCode {
    public static void main(String[] args) {
        String s = "张三 lisi";
        System.err.println(s.getBytes().length);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "zhangpei");
        map.put("pass", "123");
        String s1 = JSONObject.toJSONString(map);
        System.err.println(s1);
        Map<String, Object> parse = (Map<String, Object>) JSON.parse(s1);
        System.err.println(parse.get("username"));

    }
}
