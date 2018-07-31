package com.store.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by ZhangPei on 2018/7/23.
 */
public class TransferHandle {
    //转义方法
    public void transfer(Map<String, Object> map, String attribute, String display) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3361/sore", "root", "root");
        String sql = "select * from t_sr_cfg_code";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
    }
}
