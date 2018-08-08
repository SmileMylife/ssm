package test.service.impl;

import com.store.common.InputObject;
import com.store.common.OutputObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.dao.ITestDao;
import test.service.ITestService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ZhangPei on 2018/7/28.
 */
@Service
@Transactional
public class ITestServiceImpl implements ITestService {
    @Autowired
    private ITestDao itestDao;

    @Override
    public void showUsers(InputObject inputObject, OutputObject outputObject) throws IOException {
        List<HashMap<String, Object>> beans = itestDao.queryUsers(inputObject, outputObject);
        outputObject.setBeans(beans);

    }

    //测试事务的时候注意springMVC重复扫描的bean可能会盖掉之前spring创建的bean，可能这是两个容器，当开启事务管理的时候默认对spring容器中管理的内容进行事务管理。
    @Override
    public void testTransational(InputObject inputObject, OutputObject outputObject) {
        HashMap<String, Object> params = inputObject.getParams();
        itestDao.updateUser(params);
        //此处模拟抛异常后事务是否会回滚
        if (params.size() > 10) {
            throw new RuntimeException("运行时异常！");
        }
        params.put("id", "2");
        params.put("username", "zhangpei");
        params.put("password", "123");
        params.put("user", "user");    //表名
        itestDao.insertUser(params);

//        throw new RuntimeException("运行时异常");
    }
}
