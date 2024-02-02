package com.tpcs.demo.entity;

import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 客户信息表
 * </p>
 *
 * @author lijt
 * @since 2024-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerInfo implements Serializable {

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
     * 创建时间
     */
    private LocalDate createTime;

    /**
     * 更新时间
     */
    private LocalDate updateTime;

}
