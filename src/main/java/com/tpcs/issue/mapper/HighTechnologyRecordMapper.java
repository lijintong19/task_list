package com.tpcs.issue.mapper;

import com.tpcs.issue.entity.HighTechnologyRecordTable;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface HighTechnologyRecordMapper extends BaseMapper<HighTechnologyRecordTable> {

    List<HighTechnologyRecordTable> selectAll();
    
}
