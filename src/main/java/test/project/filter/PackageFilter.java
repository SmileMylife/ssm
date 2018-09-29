package test.project.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
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
        //此处假设需要获取到请求参数中的provCode参数，然后转换成后台使用的dbKey参数，此时就需要将原有参数做修改
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String servletPath = httpServletRequest.getServletPath();
        String provCode = servletRequest.getParameter("provCode");


        ParamsPackingServletWrapper paramsPackingServletWrapper = new ParamsPackingServletWrapper(httpServletRequest);
        String[] param = new String[1];
        param[0] = provCode;
        paramsPackingServletWrapper.setParameter("dbKey", param);
        System.out.println("执行参数封装过滤器");
        Map<String, String[]> parameterMap = paramsPackingServletWrapper.getParameterMap();
        filterChain.doFilter(paramsPackingServletWrapper, servletResponse);

        //假设在处理完请求后，需要向响应页面写入处理成功字样
        servletResponse.setContentType("text/html;charset=utf-8");
        servletResponse.getWriter().write("处理成功");
    }

    @Override
    public void destroy() {
        logger.error("过滤器销毁");
    }
}
