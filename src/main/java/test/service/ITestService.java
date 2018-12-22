package test.service;

import com.store.common.InputObject;
import com.store.common.OutputObject;
import test.common.GeneralException;

import java.io.IOException;

/**
 * Created by ZhangPei on 2018/7/28.
 */
public interface ITestService {
    public void showUsers(InputObject inputObject, OutputObject outputObject) throws IOException;
    public void testTransational(InputObject inputObject, OutputObject outputObject) throws GeneralException;
    public void switchDatasource(InputObject inputObject, OutputObject outputObject);

    public void testBatchQuery();

    public void testThreadPool();

    public void testMybatis();

    public void testPessimisticTransaction1();

    public void testPessimisticTransaction2();

    public void testSplitTable(InputObject inputObject, OutputObject outputObject);

    public void testPrintLog(InputObject inputObject, OutputObject outputObject);
}
