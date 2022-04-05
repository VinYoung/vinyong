package com.vin.web.enums;

public enum HttpStates {

    STATES_200("200", "正常状态！"),
    STATES_204("204", "正常状态，但没有返回实体！"),
    STATES_400("400", "请求有问题！"),
    STATES_401("401", "权限不足！"),
    STATES_403("403", "用户尚未登录！"),
    STATES_404("404", "资源不存在！"),
    STATES_500("500", "服务器错误！");

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
