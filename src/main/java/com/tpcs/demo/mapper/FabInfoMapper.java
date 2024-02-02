package com.tpcs.demo.mapper;

import com.tpcs.demo.entity.FabInfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 厂房信息表 Mapper 接口
 * </p>
 *
 * @author lijt
 * @since 2024-01-23
 */
@Mapper
public interface FabInfoMapper extends BaseMapper<FabInfo> {

    List<FabInfo> selectFabNameList(String customerName);

}
