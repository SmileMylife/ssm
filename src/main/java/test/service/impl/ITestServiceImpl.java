package test.service.impl;

import com.store.common.InputObject;
import com.store.common.OutputObject;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.common.GeneralException;
import test.dao.ITestDao;
import test.dbswitch.DataSourceHandle;
import test.service.ITestService;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ZhangPei on 2018/7/28.
 */
@Service
@Transactional
public class ITestServiceImpl implements ITestService {
    private final ArrayList<Map<String, Object>> result = new ArrayList();
    private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @Autowired
    private ITestDao itestDao;

    @Override
    public void showUsers(InputObject inputObject, OutputObject outputObject) throws IOException {
        List<HashMap<String, Object>> beans = itestDao.queryUsers(inputObject, outputObject);
        outputObject.setBeans(beans);

    }

    //测试事务的时候注意springMVC重复扫描的bean可能会盖掉之前spring创建的bean，可能这是两个容器，当开启事务管理的时候默认对spring容器中管理的内容进行事务管理。
    @Override
    public void testTransational(InputObject inputObject, OutputObject outputObject) throws GeneralException {
        HashMap<String, Object> params = inputObject.getParams();
        itestDao.updateUser(params);
        //此处模拟抛异常后事务是否会回滚
        if (params.size() > 1) {
            throw new GeneralException("运行时异常！");
        }
        params.put("id", "2");
        params.put("username", "zhangpei");
        params.put("password", "123");
        params.put("user", "user");    //表名
        itestDao.insertUser(params);

//        throw new RuntimeException("运行时异常");
    }

    //测试动态切库
    @Override
    public void switchDatasource(InputObject inputObject, OutputObject outputObject) {
        String provCode = DataSourceHandle.getProvCode();
        System.out.println("当前省份编码" + provCode);
        HashMap<String, Object> params = inputObject.getParams();
        List<HashMap<String, Object>> users = itestDao.queryUser(params);
        outputObject.setBeans(users);
    }

    @Override
    public void testBatchQuery() {
        Map<String, Object> map = new HashMap<String, Object>();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(4);
        map.put("list", arrayList);
        List<HashMap<String, Object>> result = itestDao.testBatchQuery(map);
        System.out.println(result);
    }

    @Override
    public void testThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3));
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                HashMap<String, Object> params = new HashMap<String, Object>();
                long start = System.currentTimeMillis();
//                final ArrayList<Map<String, Object>> result = new ArrayList();

                for (int i = 0; i < 10000; i+=2000) {
                    params.put("start", i);
                    params.put("limit", 2000);
                    List<HashMap<String, Object>> procRelSysList = itestDao.queryProRelSys(params);
                    result.addAll(procRelSysList);
                }

                /*String wrkfmId = "";
                HashMap<String, Object> problemProcesParams = new HashMap<String, Object>();
                for (Map<String, Object> map: result){
                    wrkfmId = MapUtils.getString(map, "WRKFM_ID");
                    problemProcesParams.put("wrkfmId", wrkfmId);
                    HashMap<String, Object> resultMap = itestDao.queryProblemProces(problemProcesParams);
                    map.put("hightTmpltElem", MapUtils.getString(resultMap, "WRKFM_ID"));
                }*/

                long end = System.currentTimeMillis();
                System.out.println("启动一个线程查询用时" + (end - start));
            }
        });

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                String wrkfmId = "";
                HashMap<String, Object> problemProcesParams = new HashMap<String, Object>();
                while (true) {
                    if (list.size() < 10000) {
                        Iterator<Map<String, Object>> iterator = result.iterator();
                        while (iterator.hasNext()) {
                            Map<String, Object> next = iterator.next();
                            wrkfmId = MapUtils.getString(next, "WRKFM_ID");
                            problemProcesParams.put("wrkfmId", wrkfmId);
                            HashMap<String, Object> resultMap = itestDao.queryProblemProces(problemProcesParams);
                            next.put("hightTmpltElem", MapUtils.getString(resultMap, "WRKFM_ID"));
                            list.add(next);
                            result.remove(next);
                        }
                    }else {
                        break;
                    }
                }
                long end = System.currentTimeMillis();
                System.out.println("导出所有数据所需时间为：" + (end - start));
            }
        });
    }
}
