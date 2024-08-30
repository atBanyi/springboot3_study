package com.banyi.demo.interceptor;
import com.banyi.demo.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Projectname: demo
 * @Filename: LoginInterceptor
 * @Author: BanYi
 * @email: 2271006824@qq.com
 * @Date: 2024/08/28/21:53
 * @Description: TODO
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        // 令牌验证
        String token = request.getHeader("Authorization");
        // 验证token
        try {
            Map<String, Object> parsedToken = JwtUtil.parseToken(token);
            // 有令牌就放行
            return true;
        } catch (Exception e) {
            // http 响应状态码401
            response.setStatus(401);
            // 不放行
            return false;
        }
    }
}
