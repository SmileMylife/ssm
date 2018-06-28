package com.store.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ZhangPei on 2018/6/22.
 */
public class InputObject {
    private String serviceCode;
    private String method;
    private HashMap<String, Object> params = new HashMap<String, Object>();
    private ArrayList<HashMap<String, Object>> beans = new ArrayList<HashMap<String, Object>>();

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public HashMap<String, Object> getParams() {
        return params;
    }

    public void setParams(HashMap<String, Object> params) {
        this.params = params;
    }

    public ArrayList<HashMap<String, Object>> getBeans() {
        return beans;
    }

    public void setBeans(ArrayList<HashMap<String, Object>> beans) {
        this.beans = beans;
    }
}
