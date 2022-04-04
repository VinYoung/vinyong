package com.vin.web.service;

import com.vin.web.model.ResponseModel;
import com.vin.web.model.UserModel;

import java.io.UnsupportedEncodingException;

public interface UserService {

    public ResponseModel login(UserModel userModel);

    public ResponseModel testToken();

    public ResponseModel getToken() throws UnsupportedEncodingException;

    public ResponseModel test();
}
