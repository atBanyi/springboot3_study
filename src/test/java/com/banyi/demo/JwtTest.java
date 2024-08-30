package com.banyi.demo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @Projectname: demo
 * @Filename: JwtTest
 * @Author: BanYi
 * @email: 2271006824@qq.com
 * @Date: 2024/08/28/21:15
 * @Description: TODO
 */

public class JwtTest {
    @Test
    public void testGen() {
        Map<String, Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("name","张三");
        /*生成JWT代码*/
        String token = JWT.create()
                .withClaim("user", claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))// 添加过期时间
                .sign(Algorithm.HMAC256("atBanyi"));//指定算法 配置密钥
        System.out.println(token);
    }
}
