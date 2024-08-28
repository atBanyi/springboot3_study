package com.banyi.demo.service;

import com.banyi.demo.domain.User;

import java.util.List;

/**
* @author Admin
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-08-28 14:35:19
*/
public interface UserService{
    /*根据用户名查询用户*/
    User findByUserName(String name);

    /* 用户注册*/
    void register(String name, String nationality, String passport, String phone, String participant, String occasion);
    List<User> findByAllUser();
}
