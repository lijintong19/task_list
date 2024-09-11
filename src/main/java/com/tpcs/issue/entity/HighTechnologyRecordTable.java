package com.tpcs.issue.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

@Data
@EqualsAndHashCode(callSuper = false)
public class HighTechnologyRecordTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String customer;
    private String device;
    private String orderNum;
    private String layer;
    private String jobdeckCheckTime;
    private String imaskRt;
    private String specialSizing;
    private String mpc;
    private String xppa;
    private String graphicsCheck;
    private String cdCheck;
    private String ddCheck;
    private String mfCheck;
    private String comments;
    private String opr;
    private Date createTime;
    private Date updateTime;
}
