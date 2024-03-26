package com.tpcs.demo.mapper;

import com.tpcs.demo.entity.ListDetailOperateInfo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author lijt
 * @since 2024-02-01
 */
@Mapper
public interface ListDetailOperateInfoMapper extends BaseMapper<ListDetailOperateInfo> {

    /**
     * 根据用户姓名查找具体操作信息
     * 
     * @param customerName
     * @return
     */
    List<ListDetailOperateInfo> selectDetailInfoByName(String operatorName);

    /**
     * 根据一定条件更新
     * 
     * @return
     */
    int updateInfoByConditions(Map<String, Object> map);

    /**
     * 根据一定条件查找
     */
    ListDetailOperateInfo selectInfoByConditions(Map<String, Object> map);

}
