package test.dbswitch;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态切库实现类
 * Created by ZhangPei on 2018/8/9.
 */
public class DbSwitchServiceImpl extends AbstractRoutingDataSource {

    //动态切库通过实现该抽象方法实现切库，此处应该返回配置的多数据源的key。
    @Override
    protected Object determineCurrentLookupKey() {
        //在调用dao层时，通过aop的形式捕获到省份编码，然后放进threadLocal中
        String provCode = DataSourceHandle.getProvCode();
        //此处会根据省份编码获取相应的dataSource
//        DataSource dataSource = (DataSource) MyBeanFactoryUtil.getBean(provCode + "dataSource");
        System.out.println("切库时的省份编码" + provCode);
        return provCode;
    }
}
