package test.learn.dbswitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.dao.IDatasourceInter;
import test.dao.ITestDao;

/**
 * Created by ZhangPei on 2018/9/23.
 */
@Component
public class MyClass {
    @Autowired
    private ITestDao iTestDao;

    @Autowired
    private IDatasourceInter iDatasourceInter;

    public ITestDao getiTestDao() {
        return iTestDao;
    }

    public IDatasourceInter getiDatasourceInter() {
        return iDatasourceInter;
    }
}
