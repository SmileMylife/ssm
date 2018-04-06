package com.store.dao;

import com.store.domain.User;

import java.util.List;

/**
 * Created by ZhangPei on 2018/4/3.
 */
public interface UserDao {
    public List<User> queryUser();
}
