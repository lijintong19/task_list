package com.tpcs.demo.entity;


import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

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
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
