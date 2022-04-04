package com.vin.web.enums;

public enum HttpStates {

    STATES_200("200", "正常状态"),
    STATES_404("404", "资源不存在"),
    STATES_401("401", "权限不足");
    private String stateCode;
    private String stateMessage;

    HttpStates(String stateCode, String stateMessage) {
        this.stateCode = stateCode;
        this.stateMessage = stateMessage;

    }

    public String getStateCode() {
        return stateCode;
    }

    public String getStateMessage() {
        return stateMessage;
    }
}
