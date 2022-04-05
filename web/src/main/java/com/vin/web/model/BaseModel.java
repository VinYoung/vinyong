package com.vin.web.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 基础model
 */
@Data
public class BaseModel {

    /**
     * 创建人
     */
    private String createdBy = null;

    /**
     * 创建时间
     */
    private LocalDateTime createTime = null;

    /**
     * 更新人
     */
    private String updatedBy = null;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime = null;
}
