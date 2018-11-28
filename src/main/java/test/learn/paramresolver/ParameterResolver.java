package test.learn.paramresolver;

import com.store.common.InputObject;
import org.apache.commons.collections.MapUtils;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ZhangPei on 2018/9/27.
 */
@Component
public class ParameterResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //判断方法上是否有该注解
        return methodParameter.hasParameterAnnotation(InputObjectAnnotation.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        //以下为直接将前台传入的参数封装进params
        Map<String, String[]> parameterMap = nativeWebRequest.getParameterMap();
        HashMap<String, Object> map = packageParams(parameterMap);
        InputObject inputObject = new InputObject();
        inputObject.setParams(map);
        return inputObject;
    }

    /**
     * create by zhangpei
     * 入参封装
     *
     * @param map
     */
    public HashMap<String, Object> packageParams(Map<String, String[]> map) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        if (MapUtils.isEmpty(map)) {
            return params;
        }
        Set<Map.Entry<String, String[]>> entries = map.entrySet();
        String key;
        String[] arr;
        String value;
        for (Map.Entry<String, String[]> entry : entries) {
             key =entry.getKey();
             arr =entry.getValue();
             if (arr != null) {
                 value = arr.length > 0 ? arr[0] : null;
             } else {
                 value = null;
             }
             params.put(key, value);
        }
        return params;
    }
}
