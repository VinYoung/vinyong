package com.vin.user.impl;

import com.vin.user.utils.JwtUtil;
import com.vin.web.enums.HttpStates;
import com.vin.web.model.ResponseModel;
import com.vin.web.model.UserModel;
import com.vin.web.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class UserServiceImpl implements UserService {

    private static final String AUTH_TOKEN = "x-auth-token";

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${custom.jwt.expire_time}")
    private long expireTime;

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

    @Override
    public ResponseModel getToken() throws UnsupportedEncodingException {
        String token = JwtUtil.sign("xsy", "123");
        redisTemplate.opsForValue().set(token, token, expireTime * 2 / 100, TimeUnit.SECONDS);
        return ResponseModel.success("Get token success!", token);
    }

    @Override
    public ResponseModel test() {
        System.out.println("进入测试，只有带有令牌才可以进入该方法");
        return ResponseModel.success("访问接口成功", null);
    }
}
