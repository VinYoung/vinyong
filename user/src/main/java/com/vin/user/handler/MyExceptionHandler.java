package com.vin.user.handler;

import com.vin.web.enums.HttpStates;
import com.vin.web.model.ResponseModel;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕获
 */
@Log4j
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 捕获shiro权限不足异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = AuthenticationException.class)
    @ResponseBody
    public ResponseModel exceptionHandler(AuthenticationException e) {
        log.error("出现权限不足异常！");
        return ResponseModel.error(HttpStates.STATES_401, e.getMessage());
    }
}
