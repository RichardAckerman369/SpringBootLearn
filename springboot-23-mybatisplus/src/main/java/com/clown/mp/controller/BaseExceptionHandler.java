package com.clown.mp.controller;

import com.clown.mp.common.Result;
import com.clown.mp.common.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 公共异常处理类
 */
//@ControllerAdvice
@RestControllerAdvice
public class BaseExceptionHandler {

   //@ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result error(Exception e){
        e.printStackTrace();
        return  new Result(false, StatusCode.ERROR,"执行失败",e.getMessage());
    }
}
