package com.tpcs.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单记录汇总表
 * </p>
 *
 * @author lijt
 * @since 2024-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ListTotalOperateInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名称
     */
    private String operatorName;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 总体消耗时间(分钟)
     */
    private String spentTime;

    /**
     * 任务状态
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
