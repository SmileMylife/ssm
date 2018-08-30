package test.test;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangPei on 2018/8/29.
 */
public class TestMybatis {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SqlSession sqlSession = (SqlSession) applicationContext.getBean("sqlSession");
        /*InputStream resourceAsStream = TestMybatis.class.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();*/

        ArrayList<Map<String, Object>> beans = new ArrayList<Map<String, Object>>();
        HashMap<String, Object> map = new HashMap<String, Object>();
        for (int i = 0; i < 3; i++) {
            map.put("user", "user");
            map.put("id", i);
            map.put("username", "username" + i);
            map.put("password", "password" + i);
            beans.add(map);
        }

        System.out.println(beans);

        int i = sqlSession.update("test.dao.ITestDao.testMybatis", beans);
    }
}
