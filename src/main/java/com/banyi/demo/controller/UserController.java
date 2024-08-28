package com.banyi.demo.controller;

import com.banyi.demo.domain.User;
import com.banyi.demo.result.Result;
import com.banyi.demo.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Projectname: demo
 * @Filename: UserController
 * @Author: BanYi
 * @email: 2271006824@qq.com
 * @Date: 2024/08/28/15:08
 * @Description: TODO
 */
@RestController
@RequestMapping("/user")
@Validated /** 参数校验*/
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}") String name, String nationality, String passport, String phone, String participant, String occasion) {
        /*查询用户*/
        User user=userService.findByUserName(name);
        if (user==null){
            // 没有占用
            // 注册
            userService.register(name,nationality,passport, phone,participant,occasion);
            return Result.success();
        }else {
            // 占用
            return Result.error("用户名已被占用");
        }
    }
    @GetMapping("/list")
    public Result findByAllUser(){
        List<User> user=userService.findByAllUser();
       return Result.success(user);
    }
}
