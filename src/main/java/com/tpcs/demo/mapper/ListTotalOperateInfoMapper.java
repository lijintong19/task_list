package com.tpcs.demo.mapper;

import com.tpcs.demo.entity.ListTotalOperateInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单记录汇总表 Mapper 接口
 * </p>
 *
 * @author lijt
 * @since 2024-02-21
 */
@Mapper
public interface ListTotalOperateInfoMapper extends BaseMapper<ListTotalOperateInfo> {

    /**
     * 根据用户名查询汇总信息
     * 
     * @param operateName
     * @return
     */
    List<ListTotalOperateInfo> getTotalInfoByName(String operateName);
}
