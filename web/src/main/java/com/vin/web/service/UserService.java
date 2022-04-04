package com.vin.web.service;

import com.vin.web.model.ResponseModel;
import com.vin.web.model.UserModel;

public interface UserService {

    public ResponseModel login(UserModel userModel);

    public ResponseModel testToken();
}
