package com.vin.web.model;

import lombok.Data;

/**
 * 角色Model
 */
@Data
public class RoleModel extends BaseModel {

    /**
     * 角色id
     */
    private String roleId = null;

    /**
     * 角色英文名
     */
    private String roleName = null;

    /**
     * 角色中文名
     */
    private String roleNameCn = null;

    /**
     * 父角色
     */
    private String roleFatherId = null;

    /**
     * 状态
     */
    private String roleStatus = null;

}
