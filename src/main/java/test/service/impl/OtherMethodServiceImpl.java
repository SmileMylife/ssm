package test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.dao.ITestDao;
import test.service.IOtherMethodService;

import java.util.Map;

/**
 * Created by ZhangPei on 2019/8/5.
 */
@Component
public class OtherMethodServiceImpl implements IOtherMethodService{
    @Autowired
    private ITestDao itestDao;

    public void testTransationalCallOtherMehodForUpdate(Map<String, Object> params) {
        itestDao.updateUser( params);
    }

    @Override
    public void testTransationalCallOtherMehodForInsert(Map<String, Object> params) {
        itestDao.insertUser(params);
    }


}
