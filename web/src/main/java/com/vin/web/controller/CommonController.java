package com.vin.web.controller;

import com.vin.web.enums.HttpStates;
import com.vin.web.model.ResponseModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonController {

    @RequestMapping("/error")
    public ResponseModel error() {

        return ResponseModel.error(HttpStates.STATES_500, "程序出现错误！", null);
    }

    @RequestMapping("/notRole")
    public ResponseModel notRole() {

        return ResponseModel.error(HttpStates.STATES_401, "用户权限不足！", null);
    }

    @RequestMapping("/notLogin")
    public ResponseModel notLogin() {

        return ResponseModel.error(HttpStates.STATES_403, "用户尚未登录！", null);
    }

}
