package com.store.controller;

import com.store.common.Const;
import com.store.common.ServerResponse;
import com.store.pojo.User;
import com.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


/**
 * Created by ZhangPei on 2018/3/31.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession httpSession) {
        ServerResponse<User> response = iUserService.login(username, password);
        User user = response.getData();
        user.setPassword(null);
        if (response.isSuccess()) {
            httpSession.setAttribute(Const.CURRENT_USER, user);
        }
        return response;
    }

    //登出
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession httpSession) {
        httpSession.invalidate();
        return ServerResponse.createBySuccess();
    }

    //注册
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> regist(User user, String rePassword) {
        ServerResponse<String> response = iUserService.register(user, rePassword);
        return response;
    }

    //校验是否非法
    @RequestMapping(value = "/parameterValidate", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> parameterValidate(User user, String repassword) {
        ServerResponse<String> response = iUserService.parameterValidate(user, repassword);
        return response;
    }

    //重置密码
    @RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> modifyPassword(String username, String oldPassword, String newPassword, String rePassword) {
        ServerResponse<String> response = iUserService.modifyPassword(username, oldPassword, newPassword, rePassword);
        return response;
    }

    //点击忘记密码，查询密保问题(一种是登录状态的一种是不登录状态的)
    @RequestMapping(value = "/queryQuestion", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> queryQuestion(String username) {
        ServerResponse<User> response = iUserService.queryQuestion(username);
        return response;
    }
}