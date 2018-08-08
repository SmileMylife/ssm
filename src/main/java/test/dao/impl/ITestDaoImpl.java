package test.dao.impl;

import com.store.common.InputObject;
import com.store.common.OutputObject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import test.dao.ITestDao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhangPei on 2018/7/28.
 */
public class ITestDaoImpl implements ITestDao {
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession sqlSession;

    @Override
    public void showUsers(InputObject inputObject, OutputObject outputObject) throws IOException {
        List<HashMap<String, Object>> beans = sqlSession.selectList("test.dao.ITestDao.showUsers", inputObject.getParams());
        outputObject.setBeans(beans);
    }

    @Override
    public List<HashMap<String, Object>> queryUsers(InputObject inputObject, OutputObject outputObject) {
        return null;
    }

    @Override
    public void insertDatas(Map<String, Object> map) {

    }

    @Override
    public void updateUser(Map<String, Object> map) {

    }

    @Override
    public void insertUser(Map<String, Object> map) {

    }
}
