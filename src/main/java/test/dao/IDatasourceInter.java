package test.dao;

import test.learn.dbswitch.DatasourcesClass;

import java.util.List;
import java.util.Map;

/**
 * 专用查询数据源接口
 * Created by ZhangPei on 2018/9/23.
 */
public interface IDatasourceInter {
    public List<DatasourcesClass> queryDatasources(Map<String, Object> params);

}
