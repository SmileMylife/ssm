package com.store.service.impl;

import com.store.common.ServerResponse;
import com.store.dao.UserMapper;
import com.store.pojo.User;
import com.store.service.IUserService;
import com.store.utils.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;


/**
 * Created by ZhangPei on 2018/4/3.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        if (username == null || password == null) {
            return ServerResponse.createBySuccessMessage("用户名名或密码错误");
        }
        String passwordMD5 = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.queryUser(username, passwordMD5);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户名或密码错误");
        }
        return ServerResponse.createBySuccess("登录成功", user);
    }

    //参数校验
    @Override
    public ServerResponse<String> parameterValidate(User user, String rePassword) {
        String answer = user.getAnswer();
        String email = user.getEmail();
        String password = user.getPassword();
        String phone = user.getPhone();
        String username = user.getUsername();
        if (StringUtils.isBlank(username)) {
            return ServerResponse.createByErrorMessage("用户名不能为空");
        }
        if (StringUtils.isBlank(email)) {
            return ServerResponse.createByErrorMessage("邮箱地址不能为空");
        }
        if (StringUtils.isBlank(password)) {
            return ServerResponse.createByErrorMessage("密码不能为空");
        }
        if (StringUtils.isBlank(rePassword)) {
            return ServerResponse.createByErrorMessage("重复密码不能为空");
        }
        if (!password.equals(rePassword)) {
            return ServerResponse.createByErrorMessage("两次密码不一致");
        }
        if (StringUtils.isBlank(answer)) {
            return ServerResponse.createByErrorMessage("密保问题答案不能为空");
        }
        if (StringUtils.isBlank(phone)) {
            return ServerResponse.createByErrorMessage("手机号码不能为空");
        }
        int count = userMapper.checkUsername(username);
        if (count >= 1) {
            return ServerResponse.createByErrorMessage("用户名已存在");
        }
        //校验邮箱格式
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$");
        boolean emailResult = emailPattern.matcher(email).matches();
        if (!emailResult) {
            return ServerResponse.createByErrorMessage("邮箱格式不正确");
        }
        //校验手机格式
        Pattern phonePattern = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\\\d{8}$");
        boolean phoneResult = phonePattern.matcher(phone).matches();
        if (!phoneResult) {
            ServerResponse.createByErrorMessage("手机格式不正确");
        }
        return ServerResponse.createBySuccessMessage("校验通过");
    }

    //注册
    @Override
    public ServerResponse<String> register(User user, String rePassword) {
        ServerResponse<String> response = parameterValidate(user, rePassword);
        if (response.isSuccess()) {
            String password = user.getPassword();
            //对密码进行加密
            user.setPassword(MD5Util.MD5EncodeUtf8(password));
            user.setRole(0);
            //将注册信息入表
            int insert = userMapper.insert(user);
            if (insert > 0) {
                return ServerResponse.createBySuccessMessage("注册成功");
            }else {
                return ServerResponse.createByErrorMessage("系统出错，请重新注册");
            }
        }
        return response;
    }

    //修改密码
    @Override
    public ServerResponse<String> modifyPassword(String username, String oldPassword, String newPassword, String rePassword) {
        if (username == null) {
            return ServerResponse.createByErrorMessage("用户名不能为空");
        }
        if (StringUtils.isBlank(oldPassword)) {
            return ServerResponse.createByErrorMessage("旧密码不能为空");
        }
        if (StringUtils.isBlank(newPassword)) {
            return ServerResponse.createByErrorMessage("新密码不能为空");
        }
        if (StringUtils.isBlank(rePassword)) {
            return ServerResponse.createByErrorMessage("重复密码不能为空");
        }
        //检查旧密码是否正确
        String MD5OldPassword = MD5Util.MD5EncodeUtf8(oldPassword);
        User user = userMapper.queryUser(username,MD5OldPassword);
        if (user == null) {
            return ServerResponse.createByErrorMessage("您输入的旧密码不正确");
        }
        //判断两次新密码是否一致
        if (!newPassword.equals(rePassword)) {
            return ServerResponse.createByErrorMessage("两次新密码不一致");
        }
        //更新密码
        String MD5NewPassword = MD5Util.MD5EncodeUtf8(newPassword);
        user.setPassword(MD5NewPassword);
        int i = userMapper.updateByPrimaryKey(user);
        if (i > 0) {
            return ServerResponse.createBySuccessMessage("密码修改成功");
        }
        return ServerResponse.createByErrorMessage("系统出错，请重新修改");
    }

    //查询用户密保问题
    @Override
    public ServerResponse<User> queryQuestion(String username) {
        if (username == null) {
            return ServerResponse.createByErrorMessage("请先填写用户名");
        }
        User user = userMapper.queryUser(username, "");
        return ServerResponse.createBySuccess("查询成功", user);
    }
}