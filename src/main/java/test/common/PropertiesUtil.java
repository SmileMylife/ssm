package test.common;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * Created by ZhangPei on 2018/11/8.
 */
public class PropertiesUtil {
    public static String getString(String fileName, String key) throws ConfigurationException {
        PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration(fileName);
        return propertiesConfiguration.getString(key);
    }
}
