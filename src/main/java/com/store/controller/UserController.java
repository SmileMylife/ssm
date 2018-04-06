package com.store.controller;

import com.store.domain.User;
import com.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by ZhangPei on 2018/3/31.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String username, String password) {
        List<User> users = userService.queryUser();
        for (User user: users) {
            System.err.println(user.getUsername() + user.getPassword());
        }
        return "/index";
    }
}
