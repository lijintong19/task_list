package com.tpcs.demo.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author lijt
 * @since 2024-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ListDetailOperateInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 操作员
     */
    private String operatorName;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 厂房名称
     */
    private String fabName;

    /**
     * 技术节点
     */
    private String technology;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 层次编号
     */
    private String layerNumber;

    /**
     * device编号
     */
    private String deviceNumber;

    /**
     * 任务状态
     */
    private String status;

    /**
     * 具体步骤
     */
    private String step;

    /**
     * 花费时间
     */
    private String spentTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}