package test.dao;

import com.store.common.InputObject;
import com.store.common.OutputObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhangPei on 2018/7/28.
 */
public interface ITestDao {
    public void showUsers(InputObject inputObject, OutputObject outputObject) throws IOException;   //走实现类
    public List<HashMap<String, Object>> queryUsers(InputObject inputObject, OutputObject outputObject);        //走接口
    public void insertDatas(Map<String, Object> map);
    public void updateUser(Map<String, Object> map);
    public void insertUser(Map<String, Object> map);
    public List<HashMap<String, Object>> queryUser(Map<String, Object> map);

    public List<HashMap<String, Object>> testBatchQuery(Map<String, Object> params);

    public HashMap<String, Object> queryProblemProces(Map<String, Object> map);

    public List<HashMap<String, Object>> queryProRelSys(Map<String, Object> map);
}
