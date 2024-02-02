package com.tpcs.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tpcs.demo.entity.CustomerInfo;

/**
 * <p>
 * 客户信息表 Mapper 接口
 * </p>
 *
 * @author lijt
 * @since 2024-01-22
 */
@Mapper
public interface CustomerInfoMapper extends BaseMapper<CustomerInfo> {

    List<CustomerInfo> selectAll();
}
