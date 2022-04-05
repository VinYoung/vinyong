package com.vin.web.model;

import lombok.Data;

/**
 * 用户model
 */
@Data
public class UserModel extends BaseModel {

    /**
     * 用户名
     */
    private String userName = null;

    /**
     * 密码
     */
    private String password = null;

    /**
     * 账号状态
     */
    private String status = null;

}
