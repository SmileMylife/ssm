package test.project.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.util.Map;

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
        Map<String, String[]> parameterMap = servletRequest.getParameterMap();
        
    }

    @Override
    public void destroy() {
        logger.error("过滤器销毁");
    }
}
