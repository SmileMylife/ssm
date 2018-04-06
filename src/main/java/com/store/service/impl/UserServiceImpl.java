package com.store.service.impl;

import com.store.dao.UserDao;
import com.store.domain.User;
import com.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ZhangPei on 2018/4/3.
 */
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryUser() {
        List<User> users = userDao.queryUser();
        return users;
    }
}
