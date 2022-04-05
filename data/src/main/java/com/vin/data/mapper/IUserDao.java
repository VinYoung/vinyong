package com.vin.data.mapper;

import com.vin.web.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserDao {

    /**
     * 查询符合条件的数据数
     *
     * @param userModel 用户model
     * @return
     */
    public Integer select(UserModel userModel);

    /**
     * 查询符合条件的数据
     *
     * @param userModel 用户model
     * @return
     */
    public UserModel selectByUserName(UserModel userModel);
}
