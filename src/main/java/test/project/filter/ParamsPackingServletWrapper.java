package test.project.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangPei on 2018/9/12.
 */
public class ParamsPackingServletWrapper extends HttpServletRequestWrapper {
    private Map<String, String[]> newParams = new HashMap<String, String[]>();

    public ParamsPackingServletWrapper(HttpServletRequest request) {
        super(request);
        Map<String, String[]> parameterMap = request.getParameterMap();
        this.newParams.putAll(parameterMap);
    }

    public void setParameter(String key, String[] value) {
        newParams.put(key, value);
    }

    @Override
    public String getParameter(String key) {
        return newParams.get(key)[0];       //默认取数组第一个值
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return newParams;
    }
}
