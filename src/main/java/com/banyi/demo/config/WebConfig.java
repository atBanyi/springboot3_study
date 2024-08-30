package com.banyi.demo.config;

import com.banyi.demo.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Projectname: demo
 * @Filename: WebConfig
 * @Author: BanYi
 * @email: 2271006824@qq.com
 * @Date: 2024/08/28/22:01
 * @Description: TODO
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

/*    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 登录注册接口不拦截
        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns("/user/login", "user/register");
//        WebMvcConfigurer.super.addInterceptors(registry);
    }*/

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 所有接口
                .allowCredentials(true) // 是否发送 Cookie
                .allowedOriginPatterns("*") // 支持域
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 支持方法
                .allowedHeaders("*")
                .exposedHeaders("*");
    }
}
