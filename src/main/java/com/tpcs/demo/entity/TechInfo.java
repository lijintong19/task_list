package com.tpcs.demo.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 技术节点表
 * </p>
 *
 * @author lijt
 * @since 2024-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TechInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 技术节点
     */
    private String technology;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

}
