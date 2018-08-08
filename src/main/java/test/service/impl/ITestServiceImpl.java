package test.service.impl;

import com.store.common.InputObject;
import com.store.common.OutputObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.dao.ITestDao;
import test.service.ITestService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ZhangPei on 2018/7/28.
 */
@Service
public class ITestServiceImpl implements ITestService {
    @Autowired
    private ITestDao itestDao;

    @Override
    public void showUsers(InputObject inputObject, OutputObject outputObject) throws IOException {
        List<HashMap<String, Object>> beans = itestDao.queryUsers(inputObject, outputObject);
        outputObject.setBeans(beans);

    }

    @Override
    public void testTransational(InputObject inputObject, OutputObject outputObject) {

    }
}
