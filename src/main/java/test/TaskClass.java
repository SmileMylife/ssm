package test;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.sql.*;

/**
 * Created by ZhangPei on 2018/5/7.
 */
public class TaskClass {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String username = "root";
            String pass = "root";
            String url = "jdbc:mysql://localhost:3306/test";
            connection = DriverManager.getConnection(url, username, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendSMS() throws SQLException, ConfigurationException {
        PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration("switch.properties");
        boolean aSwitch = propertiesConfiguration.getBoolean("switch");
        if (aSwitch) {
            System.err.println("task执行开始了");
        }
        /*PreparedStatement preparedStatement = null;
        try {
            String sql = "select * from t_sr_o_sms where sd_flag = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String string = resultSet.getString(1);
                System.err.println(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }*/
    }
}
