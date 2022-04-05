package com.vin.web.model;

import lombok.Data;

/**
 * 权限model
 */
@Data
public class PermissionModel extends BaseModel {

    /**
     * 权限Id
     */
    private String permissionId = null;

    /**
     * 权限英文名
     */
    private String permissionName = null;

    /**
     * 权限中文名
     */
    private String permissionNameCn = null;

    /**
     * 权限缩写
     */
    private String permissionAbbreviation = null;

    /**
     * 权限所属角色
     */
    private String permissionRole = null;

    /**
     * 权限状态
     */
    private String permissionStatus = null;

}
