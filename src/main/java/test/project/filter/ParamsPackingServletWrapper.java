package test.project.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangPei on 2018/9/12.
 */
public class ParamsPackingServletWrapper extends HttpServletRequestWrapper {
    private Map<String, Object> newParams = new HashMap<String, Object>();

    public ParamsPackingServletWrapper(HttpServletRequest request) {
        super(request);
        this.newParams.putAll(request.getParameterMap());
    }

    public void setParameter(String key, Object value) {
        newParams.put(key, value);
    }

    @Override
    public String getParameter(String key) {
        String s = newParams.get(key).toString();
        System.out.println(s);
        return newParams.get(key).toString();
    }
}
