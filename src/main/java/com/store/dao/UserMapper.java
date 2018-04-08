package com.store.dao;

import com.store.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //查询用户
    User queryUser(@Param("username") String username, @Param("password") String password);

    //查询用户数量
    int checkUsername(String username);

}