package com.vin.web.controller;

import com.vin.web.model.ResponseModel;
import com.vin.web.model.UserModel;
import com.vin.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService uerService;

    @PostMapping("/login")
    public ResponseModel login(UserModel userModel) {

        return uerService.login(userModel);
    }

    @GetMapping("/testtoken")
    public ResponseModel login() {

        return uerService.testToken();
    }
}
