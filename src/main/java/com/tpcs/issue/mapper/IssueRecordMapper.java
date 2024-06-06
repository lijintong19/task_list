package com.tpcs.issue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tpcs.issue.entity.IssueRecord;

@Mapper
public interface IssueRecordMapper extends BaseMapper<IssueRecord> {

    List<IssueRecord> selectAll();
}
