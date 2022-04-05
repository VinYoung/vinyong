package com.vin.user.impl;

import com.vin.data.mapper.IUserDao;
import com.vin.user.utils.JwtUtil;
import com.vin.web.enums.HttpStates;
import com.vin.web.model.ResponseModel;
import com.vin.web.model.UserModel;
import com.vin.web.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@Log4j
public class UserServiceImpl implements UserService {

    private static final String AUTH_TOKEN = "x-auth-token";

    @Autowired
    private IUserDao iUserDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${custom.jwt.expire_time}")
    private long expireTime;

    @Override
    public ResponseModel loginWithoutToken(UserModel user) throws UnsupportedEncodingException {

        log.info("登录开始：" + user.getUserName());
        return getToken(user);
    }

    @Override
    public ResponseModel getToken(UserModel user) throws UnsupportedEncodingException {

        log.info("校验用户：" + user.getUserName());
        int count = iUserDao.select(user);
        if (count == 0) {
            return ResponseModel.error(HttpStates.STATES_404, "用户名或密码错误！");
        }
        log.info("获取token：" + user.getUserName());
        String token = JwtUtil.sign(user.getUserName(), user.getPassword());
        redisTemplate.opsForValue().set(token, token, expireTime * 2 / 100, TimeUnit.SECONDS);
        Map<String, Object> result = new HashMap<>();
        result.put(AUTH_TOKEN, token);
        return ResponseModel.success("Login success!", result);
    }

    @Override
    public ResponseModel test() {
        System.out.println("进入测试，只有带有令牌才可以进入该方法");
        return ResponseModel.success("访问接口成功", null);
    }
}
