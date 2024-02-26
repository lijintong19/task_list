package com.tpcs.demo.service.impl;

import com.tpcs.demo.entity.CustomerInfo;
import com.tpcs.demo.mapper.CustomerInfoMapper;
import com.tpcs.demo.service.CustomerInfoService;

import lombok.AllArgsConstructor;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户信息表 服务实现类
 * </p>
 *
 * @author lijt
 * @since 2024-01-22
 */
@Service
@AllArgsConstructor
public class CustomerInfoServiceImpl extends ServiceImpl<CustomerInfoMapper, CustomerInfo>
        implements CustomerInfoService {

    @Autowired
    CustomerInfoMapper customerInfoMapper;

    /**
     * 分页方法
     */
    @Override
    public Page<CustomerInfo> selectPage(Integer pageNum, Integer pageSize) {
        Page<CustomerInfo> page = new Page<>(pageNum, pageSize);
        Page<CustomerInfo> selectPage = customerInfoMapper.selectPage(page, null);
        return selectPage;
    }

}
