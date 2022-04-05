package com.vin.web.controller;

import com.vin.web.model.ResponseModel;
import com.vin.web.model.UserModel;
import com.vin.web.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService uerService;

    @PostMapping("/loginWithoutToken")
    public ResponseModel login(@RequestBody UserModel userModel) throws UnsupportedEncodingException {

        return uerService.loginWithoutToken(userModel);
    }

    @PostMapping("/getToken")
    public ResponseModel getToken(@RequestBody UserModel user) throws UnsupportedEncodingException {
        return uerService.getToken(user);
    }

    @RequiresPermissions("user:admin")
    @RequestMapping("/test")
    public ResponseModel test() {
        return uerService.test();
    }
}
