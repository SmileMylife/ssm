package test.service;

import com.store.common.InputObject;
import com.store.common.OutputObject;

import java.io.IOException;

/**
 * Created by ZhangPei on 2018/7/28.
 */
public interface ITestService {
    public void showUsers(InputObject inputObject, OutputObject outputObject) throws IOException;
}
