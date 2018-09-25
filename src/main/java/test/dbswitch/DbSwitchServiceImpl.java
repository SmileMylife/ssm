package test.dbswitch;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;
import test.pojo.DatasourcesClass;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态切库实现类
 * Created by ZhangPei on 2018/8/9.
 */
@Component
public class DbSwitchServiceImpl extends AbstractRoutingDataSource {
    private final Logger logger = LoggerFactory.getLogger(DbSwitchServiceImpl.class);

    @Autowired
    private DatasourcesClass myClass;       //注入该类并无报错，如果注入mybatis的类，则会报错，原因是在spring创建mybatis的代理对象的时候需要sqlSessionFactory来支撑，此时该对象还未创建

    /**
     * 初始化的时候加载所有数据源信息，并设置默认数据源，该构造器为私有，但是spring仍可以创建对象
     */
    private DbSwitchServiceImpl() throws SQLException, ClassNotFoundException {
        System.out.println("===============================================================");
        Map<Object, Object> map = queryAllDatasources();
        if (MapUtils.isEmpty(map)) {
            throw new RuntimeException("构建动态切库数据源失败！");
        }
        setTargetDataSources(map);
        setDefaultTargetDataSource(map.get("test"));    //可以后期优化
    }

    /**
     * 动态切库通过实现该抽象方法实现切库，此处应该返回配置的多数据源的key。
     * 在调用dao层时，通过aop的形式捕获到省份编码，然后放进threadLocal中
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        String dbKey = DataSourceHandle.getDbKey();
        //此处会根据省份编码获取相应的dataSource
        System.out.println("切库时的省份编码" + dbKey);
        return dbKey;
    }

    /**
     * create by zhangpei
     * 查询所有数据源
     */
    protected Map<Object, Object> queryAllDatasources() throws ClassNotFoundException, SQLException {
//        List<DatasourcesClass> datasourcesClasses = iDatasourceInter.queryDatasources(new HashMap<String, Object>()); 此处使用mybatis不可以
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ngwf?characterEncoding=utf-8", "root", "root");
        String sql = "SELECT ID, DB_KEY, DRIVE_CLASS_NAME, URL, USERNAME, PASSWORD FROM T_SR_DATASOURCE";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet == null) {
            throw new RuntimeException("查询数据源失败，请检查数据库配置");
        }
        BasicDataSource basicDataSource;
        String dbKey;
        String driverClassName;
        String url;
        String username;
        String password;
        HashMap<Object, Object> result = new HashMap<Object, Object>();
        while (resultSet.next()) {
            dbKey = resultSet.getString("DB_KEY");
            driverClassName = resultSet.getString("DRIVE_CLASS_NAME");
            url = resultSet.getString("URL");
            username = resultSet.getString("USERNAME");
            password = resultSet.getString("PASSWORD");

            basicDataSource = new BasicDataSource();
            basicDataSource.setDriverClassName(driverClassName);
            basicDataSource.setUrl(url);
            basicDataSource.setUsername(username);
            basicDataSource.setPassword(password);

            result.put(dbKey, basicDataSource);
        }
        return result;
    }
}
