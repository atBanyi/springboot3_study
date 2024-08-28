package com.banyi.demo.error;

import com.banyi.demo.result.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created with IntelliJ IDEA.
 *
 * @Projectname: demo
 * @Filename: GlobalExceptionHandler
 * @Author: BanYi
 * @email: 2271006824@qq.com
 * @Date: 2024/08/28/16:26
 * @Description: TODO
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作失败");
    }
}
