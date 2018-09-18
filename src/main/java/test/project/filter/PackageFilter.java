package test.project.filter;

import com.store.common.InputObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ZhangPei on 2018/6/22.
 */
public class PackageFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(PackageFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.error("过滤器初始化开始");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        InputObject inputObject = new InputObject();
        HashMap<String, Object> params = inputObject.getParams();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();

        //封装进入inputobject
        for (Map.Entry<String, String[]> entry : entries) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            if (values == null) {
                params.put(key, null);
            } else {
                params.put(key, values.length > 0 ? values[0] : null);
            }
        }

        params.put("test", "test");
        ParamsPackingServletWrapper paramsPackingServletWrapper = new ParamsPackingServletWrapper(httpServletRequest);
        paramsPackingServletWrapper.setParameter("inputObject", "123213123");
        filterChain.doFilter(httpServletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.error("过滤器销毁");
    }
}
