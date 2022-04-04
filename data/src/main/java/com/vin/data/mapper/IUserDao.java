package com.vin.data.mapper;

import com.vin.web.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserDao {

    public UserModel selectByUserName(UserModel userModel);
}
