package com.banyi.demo.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Projectname: demo
 * @Filename: Result
 * @Author: BanYi
 * @email: 2271006824@qq.com
 * @Date: 2024/08/28/14:56
 * @Description: TODO 统一响应结果
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result <T>{
    private Integer code;/*业务状态码*/
    private String message;/* 提示信息*/
    private T data;/* 响应数据*/

    /* 响应成功 返回数据*/
    public static <E> Result<E> success(E data){
        return new Result<>(0,"操作成功",data);
    }
    /* 普通响应*/
    public static Result success(){
        return new Result(0,"操作成功",null);
    }
    /* 错误响应*/
    public static  Result error(String message){
        return new Result(1,message,null);
    }
}
