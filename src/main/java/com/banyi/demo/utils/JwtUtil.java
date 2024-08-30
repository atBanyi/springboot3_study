package com.banyi.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Projectname: demo
 * @Filename: JwtUtil
 * @Author: BanYi
 * @email: 2271006824@qq.com
 * @Date: 2024/08/28/21:31
 * @Description: TODO
 */
public class JwtUtil {
    private static final String KEY = "atBanYI";

    /*接收业务数据，生成token，并返回业务数据*/
    public static String generationToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))
                .sign(Algorithm.HMAC256(KEY));
    }
    /*接收token，验证token，返回业务数据*/
    public static Map<String,Object> parseToken(String token){
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}

