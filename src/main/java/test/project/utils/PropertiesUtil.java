package com.project.utils;

import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * Created by ZhangPei on 2018/6/22.
 */
public class PropertiesUtil {

    /**
     * 获取某个配置文件中的某个键的值
     * @param fileName
     * @param key
     * @return
     * @throws Exception
     */
    public static String getValueByFile(String fileName, String key) throws Exception {
        PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration(fileName);
        return propertiesConfiguration.getString(key);
    }
}
