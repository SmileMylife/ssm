package com.store.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ZhangPei on 2018/6/22.
 */
public class OutputObject implements Cloneable, Serializable {
    private String rtnCode;
    private String rtnMsg;
    private HashMap<String, Object> bean = new HashMap<String, Object>();
    private List<HashMap<String, Object>> beans = new ArrayList<HashMap<String, Object>>();
    private Object object;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(String rtnCode) {
        this.rtnCode = rtnCode;
    }

    public String getRtnMsg() {
        return rtnMsg;
    }

    public void setRtnMsg(String rtnMsg) {
        this.rtnMsg = rtnMsg;
    }

    public HashMap<String, Object> getBean() {
        return bean;
    }

    public void setBean(HashMap<String, Object> bean) {
        this.bean = bean;
    }

    public List<HashMap<String, Object>> getBeans() {
        return beans;
    }

    public void setBeans(List<HashMap<String, Object>> beans) {
        this.beans = beans;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "OutputObject{" +
                "rtnCode='" + rtnCode + '\'' +
                ", rtnMsg='" + rtnMsg + '\'' +
                ", bean=" + bean +
                ", beans=" + beans +
                ", object=" + object +
                '}';
    }
}
