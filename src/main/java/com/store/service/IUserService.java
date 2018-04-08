package com.store.service;

import com.store.common.ServerResponse;
import com.store.pojo.User;

/**
 * Created by ZhangPei on 2018/4/3.
 */
public interface IUserService {
    //用户登录
    ServerResponse<User> login(String username, String password);

    //参数校验
    ServerResponse<String> parameterValidate(User user, String repassword);

    //注册
    ServerResponse<String> register(User user, String rePassword);
}
