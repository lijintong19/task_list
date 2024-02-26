package com.tpcs.demo.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tpcs.demo.entity.CustomerInfo;

/**
 * <p>
 * 客户信息表 服务类
 * </p>
 *
 * @author lijt
 * @since 2024-01-22
 */
@Service
public interface CustomerInfoService extends IService<CustomerInfo> {

    /**
     * 分页查询方法
     * 
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<CustomerInfo> selectPage(Integer pageNum, Integer pageSize);

}
