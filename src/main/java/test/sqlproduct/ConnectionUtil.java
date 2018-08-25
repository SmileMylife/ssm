package test.sqlproduct;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by ZhangPei on 2018/8/23.
 */
public class ConnectionUtil {
    public static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ngwf";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            connection = null;
        }
    }
}
