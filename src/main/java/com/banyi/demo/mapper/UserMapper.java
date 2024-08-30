package com.banyi.demo.mapper;

import com.banyi.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author Admin
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2024-08-28 14:35:19
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper {
    /*根据用户名查询*/
    @Select("select * from user where name=#{name}")
    User findByUserName(String name);

    @Select("insert into user(name,nationality,passport,phone,participant,occasion)" + "values(#{name}, #{nationality}, #{passport}, #{phone}, #{participant}, #{occasion})")
    void add(User user);
    @Select("select * from user")
    List<User> findByAllUser();
}




