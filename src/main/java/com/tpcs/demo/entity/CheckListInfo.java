package com.tpcs.demo.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * checkList步骤描述表
 * </p>
 *
 * @author lijt
 * @since 2024-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CheckListInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 备注图片路径
     */
    private String remarkPicturePath;

    /**
     * 步骤顺序
     */
    private String sequence;

    /**
     * 厂房名称
     */
    private String fabName;

    /**
     * 步骤描述
     */
    private String listDesc;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
