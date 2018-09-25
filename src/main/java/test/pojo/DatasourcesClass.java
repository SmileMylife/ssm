package test.pojo;

import org.springframework.stereotype.Component;

/**
 * 数据库数据源实体类
 * Created by ZhangPei on 2018/9/23.
 */
@Component
public class DatasourcesClass {
    private Integer id;
    private String dbKey;
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public Integer getId() {
        return id;
    }

    public String getDbKey() {
        return dbKey;
    }

    public void setDbKey(String dbKey) {
        this.dbKey = dbKey;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
