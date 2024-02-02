package com.tpcs.demo.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 厂房信息表
 * </p>
 *
 * @author lijt
 * @since 2024-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FabInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 厂房名称
     */
    private String fabName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
