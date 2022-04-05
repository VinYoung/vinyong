package com.vin.web.model;

import com.vin.web.enums.HttpStates;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseModel {

    private String stateCode = "200";
    private String message = null;
    private Object result = null;

    /**
     * 正常返回
     *
     * @param message
     * @param result
     * @return
     */
    public static ResponseModel success(String message, Object result) {
        return ResponseModel
                .builder().stateCode(HttpStates.STATES_200.getStateCode()).message(message).result(result).build();
    }

    /**
     * 正常返回
     *
     * @param message
     * @return
     */
    public static ResponseModel success(String message) {
        return ResponseModel
                .builder().stateCode(HttpStates.STATES_204.getStateCode()).message(message).result(null).build();
    }

    /**
     * 异常返回
     *
     * @param httpStates
     * @param message
     * @param result
     * @return
     */
    public static ResponseModel error(HttpStates httpStates, String message, Object result) {
        return ResponseModel
                .builder().stateCode(httpStates.getStateCode()).message(message).result(result).build();
    }

    /**
     * 异常返回
     *
     * @param httpStates
     * @param message
     * @return
     */
    public static ResponseModel error(HttpStates httpStates, String message) {
        return ResponseModel
                .builder().stateCode(httpStates.getStateCode()).message(message).result(null).build();
    }
}
