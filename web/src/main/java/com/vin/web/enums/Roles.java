package com.vin.web.enums;

public enum Roles {

    ID_0("0", "superAdmin", "超级管理员"),
    ID_1("1", "用户已失效！", ""),
    ID_2("2", "用户已失效！", "");

    private String roleId;
    private String roleName;
    private String roleNameCn;

    Roles(String roleId, String roleName, String roleNameCn) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleNameCn = roleNameCn;

    }

    public String getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRoleNameCn() {
        return roleNameCn;
    }
}
