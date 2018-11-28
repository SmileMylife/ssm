package test.dao.impl;

/**
 * Created by ZhangPei on 2018/7/28.
 */
/*@Repository
public class ITestDaoImpl implements ITestDao {
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession sqlSession;

    @Override
    public void showUsers(InputObject inputObject, OutputObject outputObject) throws IOException {
        List<HashMap<String, Object>> beans = sqlSession.selectList("test.dao.ITestDao.showUsers", inputObject.getParams());
        outputObject.setBeans(beans);
    }

    @Override
    public List<HashMap<String, Object>> queryUsers(InputObject inputObject, OutputObject outputObject) {
        return null;
    }

    @Override
    public void insertDatas(Map<String, Object> map) {

    }

    @Override
    public void updateUser(Map<String, Object> map) {

    }

    @Override
    public void insertUser(Map<String, Object> map) {

    }

    @Override
    public List<HashMap<String, Object>> queryUser(Map<String, Object> map) {
        DataSourceHandle.setProvCode("dataSource1");
        List<HashMap<String, Object>> result = sqlSession.selectList("test.dao.ITestDao.queryUser", map);
        return result;
    }
}*/
