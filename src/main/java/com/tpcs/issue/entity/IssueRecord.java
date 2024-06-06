package com.tpcs.issue.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class IssueRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Date issueDate;
    private String issueDescription;
    private String issueStatus;
    private String reportBy;
    private Date createTime;
    private Date updateTime;
    private String comment;
}
