package com.tpcs.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tpcs.demo.entity.CheckListInfo;

/**
 * <p>
 * checkList步骤描述表 Mapper 接口
 * </p>
 *
 * @author lijt
 * @since 2024-01-09
 */
@Mapper
public interface CheckListInfoMapper extends BaseMapper<CheckListInfo> {

    /**
     * 查找全部信息
     * 
     * @return
     */
    List<CheckListInfo> selectAll();

}
