package com.banyi.demo.controller;
import com.banyi.demo.domain.User;
import com.banyi.demo.result.Result;
import com.banyi.demo.service.UserService;
import com.banyi.demo.utils.JwtUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        /*查询用户*/
        User existingUser=userService.findByUserName(user.getName());
        if (existingUser==null){
            // 没有占用
            // 注册
            userService.register(user);
            return Result.success(user);
        }else {
            // 占用
            return Result.error("用户名已被占用");
        }
    }
    /** 用户登录*/
    @PostMapping("/login")
    public Result<String> login(String name,String phone){
        /*根据用户名查询用户*/
        User user = userService.findByUserName(name);
        /*判断用户是否存在*/
        if (user == null) {
           return Result.error("不存在该用户");
        }
        //
        /*判断密码是否正确 */
        if (phone.equals(user.getPhone())) {
            /*登录成功*/
            Map<String,Object> claims=new HashMap<>();
            claims.put("name",user.getName());
            claims.put("phone",user.getPhone());
            String token = JwtUtil.generationToken(claims);
            return Result.success(token);
        }
        return Result.error("登录失败");
    }
    @GetMapping("/list")
    public Result findByAllUser(){
        List<User> user=userService.findByAllUser();
       return Result.success(user);
    }
    /*查寻用户信息*/
    @GetMapping("/userInfo")
    public Result<User> userInfo(@RequestHeader(name = "Authorization") String token){
        Map<String, Object> map = JwtUtil.parseToken(token);
        String name = (String) map.get("name");
        User user = userService.findByUserName(name);
        return Result.success(user);
    }
}
