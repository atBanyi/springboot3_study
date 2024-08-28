package com.banyi.demo.service.impl;
import com.banyi.demo.domain.User;
import com.banyi.demo.mapper.UserMapper;
import com.banyi.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Admin
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-08-28 14:35:19
*/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String name) {
        User u=userMapper.findByUserName(name);
        return u;
    }

    @Override
    public void register(String name, String nationality, String passport, String phone, String participant, String occasion) {
        userMapper.add(name,nationality,passport,phone,participant,occasion);
    }

    @Override
    public List<User> findByAllUser() {
        return userMapper.findByAllUser();
    }
}




