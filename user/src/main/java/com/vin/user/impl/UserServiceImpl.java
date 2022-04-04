package com.vin.user.impl;

import com.vin.web.enums.HttpStates;
import com.vin.web.model.ResponseModel;
import com.vin.web.model.UserModel;
import com.vin.web.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserServiceImpl implements UserService {

    private static final String AUTH_TOKEN = "x-auth-token";

    @Override
    public ResponseModel login(UserModel userModel) {

        UsernamePasswordToken token = new UsernamePasswordToken(userModel.getUserName(), userModel.getPassword());

        try {
            SecurityUtils.getSubject().login(token);
        } catch (AuthenticationException e) {
            return ResponseModel.error(HttpStates.STATES_401, "权限不足！", null);
        }

        Subject subject = SecurityUtils.getSubject();
        Serializable tokenId = subject.getSession().getId();

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put(AUTH_TOKEN, String.valueOf(tokenId));

        return ResponseModel.success("登录成功！", resultMap);
    }

    @Override
    public ResponseModel testToken() {

        return ResponseModel.builder().message("获取到信息！").build();
    }
}
