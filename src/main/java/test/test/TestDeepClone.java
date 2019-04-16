package test.test;

import com.store.common.OutputObject;

import java.util.HashMap;

/**
 * Created by ZhangPei on 2019/4/15.
 */
public class TestDeepClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        OutputObject output = new OutputObject();

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("provCode", "00030016");

        output.setBean(map);

        OutputObject outputObject;


        outputObject = (OutputObject) output.clone();

        outputObject.getBean().put("tenantId", "100000");

        System.out.println(output.getBean());


    }
}
