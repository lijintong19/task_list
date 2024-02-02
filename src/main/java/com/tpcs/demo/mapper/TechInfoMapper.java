package com.tpcs.demo.mapper;

import com.tpcs.demo.entity.TechInfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 技术节点表 Mapper 接口
 * </p>
 *
 * @author lijt
 * @since 2024-02-01
 */
@Mapper
public interface TechInfoMapper extends BaseMapper<TechInfo> {

    /**
     * 查询所有数据
     * 
     * @return
     */
    List<TechInfo> selectAllInfos();

}
