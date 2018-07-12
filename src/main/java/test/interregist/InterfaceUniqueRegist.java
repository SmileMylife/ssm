package test.interregist;

import com.store.common.InputObject;
import com.store.common.OutputObject;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;

import java.util.HashMap;

/**
 * Created by ZhangPei on 2018/7/3.
 */
@Controller
public class InterfaceUniqueRegist {
    public void interfaceUniqueEntrance(InputObject inputObject, OutputObject outputObject) throws Exception {
        HashMap<String, Object> params = inputObject.getParams();
        if (StringUtils.isBlank(MapUtils.getString(params, "csfCode"))) {
            throw new Exception("csfCode不能为空!");
        }
        //根据csfCode获取service及其方法

    }

}
