package com.by.appregistration.common.exception;


import com.by.appregistration.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    @ExceptionHandler(AppRegistrationException.class)
    @ResponseBody
    public Result error(AppRegistrationException e) {
        e.printStackTrace();
        return Result.fail();
    }
}
