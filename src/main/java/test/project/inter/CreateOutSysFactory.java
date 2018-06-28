package test.project.inter;

/**
 * Created by ZhangPei on 2018/6/22.
 */
public interface CreateOutSysFactory {
    public OutSysOperateService createOutSys(String sysCode) throws Exception;
}
