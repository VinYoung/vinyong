package com.vin.web.service;

import com.vin.web.model.ResponseModel;
import com.vin.web.model.UserModel;

import java.io.UnsupportedEncodingException;

public interface UserService {

    public ResponseModel loginWithoutToken(UserModel userModel) throws UnsupportedEncodingException;

    public ResponseModel getToken(UserModel user) throws UnsupportedEncodingException;

    public ResponseModel test();
}
