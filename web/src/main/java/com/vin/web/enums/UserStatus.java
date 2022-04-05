package com.vin.web.enums;

public enum UserStatus {

    STATUS_0("0", "用户处于有效期内！"),
    STATUS_1("1", "用户已失效！");

    private String statusCode;
    private String stateInfo;

    UserStatus(String statusCode, String stateInfo) {
        this.statusCode = statusCode;
        this.stateInfo = stateInfo;

    }

    public String getStateCode() {
        return statusCode;
    }

    public String getStateMessage() {
        return stateInfo;
    }
}
