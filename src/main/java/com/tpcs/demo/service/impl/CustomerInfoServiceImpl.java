package com.tpcs.demo.service.impl;

import com.tpcs.demo.entity.CustomerInfo;
import com.tpcs.demo.mapper.CustomerInfoMapper;
import com.tpcs.demo.service.CustomerInfoService;

import lombok.AllArgsConstructor;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CustomerInfoServiceImpl extends ServiceImpl<CustomerInfoMapper, CustomerInfo> implements CustomerInfoService {

}
