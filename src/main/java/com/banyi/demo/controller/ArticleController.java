package com.banyi.demo.controller;

import com.banyi.demo.result.Result;
import com.banyi.demo.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Projectname: demo
 * @Filename: ArticleController
 * @Author: BanYi
 * @email: 2271006824@qq.com
 * @Date: 2024/08/28/20:56
 * @Description: TODO
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    public Result<String> list(/*@RequestHeader(name = "Authorization") String token, HttpServletResponse httpServletResponse*/) {
       /* // 验证token
        try {
            Map<String, Object> parsedToken = JwtUtil.parseToken(token);
            // 有令牌就能看到数据
            return Result.success("所有的文章数据");
        } catch (Exception e) {
            // http 响应状态码401
            httpServletResponse.setStatus(401);
            return Result.error("未登录");
        }*/
        return Result.success("所有的文章数据");
    }
}
