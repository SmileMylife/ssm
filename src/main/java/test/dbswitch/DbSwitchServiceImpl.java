package test.dbswitch;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;
import test.dao.IDatasourceInter;
import test.dao.ITestDao;
import test.pojo.DatasourcesClass;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 动态切库实现类
 * Created by ZhangPei on 2018/8/9.
 */
@Component
@Order(-1)
public class DbSwitchServiceImpl extends AbstractRoutingDataSource {
    private final Logger logger = LoggerFactory.getLogger(DbSwitchServiceImpl.class);

    @Autowired
    public IDatasourceInter iDatasourceInter;

    @Autowired
    public ITestDao iTestDao;

    /**
     * 初始化的时候加载所有数据源信息，并设置默认数据源，该构造器为私有，但是spring仍可以创建对象
     */
    private DbSwitchServiceImpl() {
        /*System.out.println("===============================================================");
        Map<Object, Object> map = queryAllDatasources();
        if (MapUtils.isEmpty(map)) {
            throw new RuntimeException("构建动态切库数据源失败！");
        }
        setTargetDataSources(map);
        setDefaultTargetDataSource(map.get("test"));    //可以后期优化*/
    }

    /**
     * 动态切库通过实现该抽象方法实现切库，此处应该返回配置的多数据源的key。
     * 在调用dao层时，通过aop的形式捕获到省份编码，然后放进threadLocal中
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        String provCode = DataSourceHandle.getProvCode();
        //此处会根据省份编码获取相应的dataSource
        System.out.println("切库时的省份编码" + provCode);
        return provCode;
    }

    /**
     * create by zhangpei
     * 查询所有数据源
     */
    /*protected Map<Object, Object> queryAllDatasources() {
        List<DatasourcesClass> datasourcesClasses = iDatasourceInter.queryDatasources(new HashMap<String, Object>());
        if (CollectionUtils.isEmpty(datasourcesClasses)) {
            throw new RuntimeException("查询数据源失败，请检查数据库配置");
        }
        //封装数据源对象
        Iterator<DatasourcesClass> iterator = datasourcesClasses.iterator();
        DatasourcesClass temp;
        BasicDataSource basicDataSource;
        HashMap<Object, Object> result = new HashMap<Object, Object>();

        while (iterator.hasNext()) {
            temp = iterator.next();

            basicDataSource = new BasicDataSource();
            basicDataSource.setDriverClassName(temp.getDriverClassName());
            basicDataSource.setUrl(temp.getUrl());
            basicDataSource.setUsername(temp.getUsername());
            basicDataSource.setPassword(temp.getPassword());

            result.put(temp.getDbKey(), basicDataSource);
        }
        return result;
    }*/
}
